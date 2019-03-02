package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScRechargeEntity;
import net.chenlin.dp.modules.sc.dao.ScRechargeMapper;
import net.chenlin.dp.modules.sc.service.ScRechargeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scRechargeService")
public class ScRechargeServiceImpl implements ScRechargeService {

	@Autowired
    private ScRechargeMapper scRechargeMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScRechargeEntity> listScRecharge(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScRechargeEntity> page = new Page<>(query);
		scRechargeMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scRecharge
     * @return
     */
	@Override
	public R saveScRecharge(ScRechargeEntity scRecharge) {
		int count = scRechargeMapper.save(scRecharge);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScRechargeById(Long id) {
		ScRechargeEntity scRecharge = scRechargeMapper.getObjectById(id);
		return CommonUtils.msg(scRecharge);
	}

    /**
     * 修改
     * @param scRecharge
     * @return
     */
	@Override
	public R updateScRecharge(ScRechargeEntity scRecharge) {
		int count = scRechargeMapper.update(scRecharge);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scRechargeMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
