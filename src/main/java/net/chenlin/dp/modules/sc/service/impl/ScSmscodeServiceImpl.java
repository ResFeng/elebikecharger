package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScSmscodeEntity;
import net.chenlin.dp.modules.sc.dao.ScSmscodeMapper;
import net.chenlin.dp.modules.sc.service.ScSmscodeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scSmscodeService")
public class ScSmscodeServiceImpl implements ScSmscodeService {

	@Autowired
    private ScSmscodeMapper scSmscodeMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScSmscodeEntity> listScSmscode(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScSmscodeEntity> page = new Page<>(query);
		scSmscodeMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scSmscode
     * @return
     */
	@Override
	public R saveScSmscode(ScSmscodeEntity scSmscode) {
		int count = scSmscodeMapper.save(scSmscode);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScSmscodeById(Long id) {
		ScSmscodeEntity scSmscode = scSmscodeMapper.getObjectById(id);
		return CommonUtils.msg(scSmscode);
	}

    /**
     * 修改
     * @param scSmscode
     * @return
     */
	@Override
	public R updateScSmscode(ScSmscodeEntity scSmscode) {
		int count = scSmscodeMapper.update(scSmscode);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scSmscodeMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
