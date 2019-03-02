package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScChargeEntity;
import net.chenlin.dp.modules.sc.dao.ScChargeMapper;
import net.chenlin.dp.modules.sc.service.ScChargeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scChargeService")
public class ScChargeServiceImpl implements ScChargeService {

	@Autowired
    private ScChargeMapper scChargeMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScChargeEntity> listScCharge(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScChargeEntity> page = new Page<>(query);
		scChargeMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scCharge
     * @return
     */
	@Override
	public R saveScCharge(ScChargeEntity scCharge) {
		int count = scChargeMapper.save(scCharge);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScChargeById(Long id) {
		ScChargeEntity scCharge = scChargeMapper.getObjectById(id);
		return CommonUtils.msg(scCharge);
	}

    /**
     * 修改
     * @param scCharge
     * @return
     */
	@Override
	public R updateScCharge(ScChargeEntity scCharge) {
		int count = scChargeMapper.update(scCharge);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scChargeMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
