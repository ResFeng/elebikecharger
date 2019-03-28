package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScChargeprofitEntity;
import net.chenlin.dp.modules.sc.dao.ScChargeprofitMapper;
import net.chenlin.dp.modules.sc.service.ScChargeprofitService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scChargeprofitService")
public class ScChargeprofitServiceImpl implements ScChargeprofitService {

	@Autowired
    private ScChargeprofitMapper scChargeprofitMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScChargeprofitEntity> listScChargeprofit(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScChargeprofitEntity> page = new Page<>(query);
		scChargeprofitMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 列出当日运营商收益
	 * @param params
	 * @return
	 */
	@Override
	public Page<ScChargeprofitEntity> getProfit(Map<String, Object> params){
		Query query = new Query(params);
		Page<ScChargeprofitEntity> page = new Page<>(query);
		scChargeprofitMapper.getProfit(page, query);
		return page;
	}

	/**
	 * 列出当日运营商收益
	 * @param params
	 * @return
	 */
	@Override
	public Page<ScChargeprofitEntity> getProfitReport(Map<String, Object> params){
		Query query = new Query(params);
		Page<ScChargeprofitEntity> page = new Page<>(query);
		scChargeprofitMapper.getProfitReport(page, query);
		return page;
	}

	/**
	 * 列出当日运营商收益
	 * @param params
	 * @return
	 */
	@Override
	public Page<ScChargeprofitEntity> listProfit(Map<String, Object> params){
		Query query = new Query(params);
		Page<ScChargeprofitEntity> page = new Page<>(query);
		scChargeprofitMapper.listProfit(page, query);
		return page;
	}

    /**
     * 新增
     * @param scChargeprofit
     * @return
     */
	@Override
	public R saveScChargeprofit(ScChargeprofitEntity scChargeprofit) {
		int count = scChargeprofitMapper.save(scChargeprofit);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScChargeprofitById(Long id) {
		ScChargeprofitEntity scChargeprofit = scChargeprofitMapper.getObjectById(id);
		return CommonUtils.msg(scChargeprofit);
	}

    /**
     * 修改
     * @param scChargeprofit
     * @return
     */
	@Override
	public R updateScChargeprofit(ScChargeprofitEntity scChargeprofit) {
		int count = scChargeprofitMapper.update(scChargeprofit);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scChargeprofitMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
