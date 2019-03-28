package net.chenlin.dp.modules.sc.service;

import java.util.List;
import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScChargeEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScChargeService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScChargeEntity> listScCharge(Map<String, Object> params);

    /**
     * 获取端口使用统计
     * @param params
     * @return
    */
    List<ScChargeEntity> getSerialReport(Map<String, Object> params);

    /**
     * 新增
     * @param scCharge
     * @return
     */
	R saveScCharge(ScChargeEntity scCharge);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScChargeById(Long id);

    /**
     * 修改
     * @param scCharge
     * @return
     */
	R updateScCharge(ScChargeEntity scCharge);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
