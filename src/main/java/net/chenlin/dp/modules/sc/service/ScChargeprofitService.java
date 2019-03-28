package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScChargeprofitEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScChargeprofitService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScChargeprofitEntity> listScChargeprofit(Map<String, Object> params);

    /**
     * 列出当日运营商收益
     * @param params
     * @return
     */
    Page<ScChargeprofitEntity> getProfit(Map<String, Object> params);

    /**
     * 设备使用统计
     * @param params
     * @return
     */
    Page<ScChargeprofitEntity> getProfitReport(Map<String, Object> params);

    /**
     * 列出当日运营商收益
     * @param params
     * @return
     */
    Page<ScChargeprofitEntity> listProfit(Map<String, Object> params);

    /**
     * 新增
     * @param scChargeprofit
     * @return
     */
	R saveScChargeprofit(ScChargeprofitEntity scChargeprofit);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScChargeprofitById(Long id);

    /**
     * 修改
     * @param scChargeprofit
     * @return
     */
	R updateScChargeprofit(ScChargeprofitEntity scChargeprofit);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
