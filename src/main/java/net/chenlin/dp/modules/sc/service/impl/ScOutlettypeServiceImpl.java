package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScOutlettypeEntity;
import net.chenlin.dp.modules.sc.dao.ScOutlettypeMapper;
import net.chenlin.dp.modules.sc.service.ScOutlettypeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scOutlettypeService")
public class ScOutlettypeServiceImpl implements ScOutlettypeService {

	@Autowired
    private ScOutlettypeMapper scOutlettypeMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScOutlettypeEntity> listScOutlettype(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScOutlettypeEntity> page = new Page<>(query);
		scOutlettypeMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scOutlettype
     * @return
     */
	@Override
	public R saveScOutlettype(ScOutlettypeEntity scOutlettype) {
		int count = scOutlettypeMapper.save(scOutlettype);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScOutlettypeById(Long id) {
		ScOutlettypeEntity scOutlettype = scOutlettypeMapper.getObjectById(id);
		return CommonUtils.msg(scOutlettype);
	}

    /**
     * 修改
     * @param scOutlettype
     * @return
     */
	@Override
	public R updateScOutlettype(ScOutlettypeEntity scOutlettype) {
		int count = scOutlettypeMapper.update(scOutlettype);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scOutlettypeMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
