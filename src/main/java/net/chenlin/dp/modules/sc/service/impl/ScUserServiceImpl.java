package net.chenlin.dp.modules.sc.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.dao.ScUserMapper;
import net.chenlin.dp.modules.sc.entity.ScUserEntity;
import net.chenlin.dp.modules.sc.service.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("scUserService")
public class ScUserServiceImpl implements ScUserService {

    @Autowired
    private ScUserMapper scUserMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public Page<ScUserEntity> listForPage(Map<String, Object> params) {
        Query query = new Query(params);
        Page<ScUserEntity> page = new Page<>(query);
        scUserMapper.listForPage(page, query);
        return page;
    }

    /**
     * 新增
     * @param scUpload
     * @return
     */
    @Override
    public R save(ScUserEntity scUpload) {
        int count = scUserMapper.save(scUpload);
        return CommonUtils.msg(count);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public R getObjectById(Long id) {
        ScUserEntity scUpload = scUserMapper.getObjectById(id);
        return CommonUtils.msg(scUpload);
    }

    /**
     * 修改
     * @param scUpload
     * @return
     */
    @Override
    public R update(ScUserEntity scUpload) {
        int count = scUserMapper.update(scUpload);
        return CommonUtils.msg(count);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public R batchRemove(Long[] id) {
        int count = scUserMapper.batchRemove(id);
        return CommonUtils.msg(id, count);
    }
}
