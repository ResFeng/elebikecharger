package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScRechargeEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScRechargeService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScRechargeEntity> listScRecharge(Map<String, Object> params);

    /**
     * 新增
     * @param scRecharge
     * @return
     */
	R saveScRecharge(ScRechargeEntity scRecharge);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScRechargeById(Long id);

    /**
     * 修改
     * @param scRecharge
     * @return
     */
	R updateScRecharge(ScRechargeEntity scRecharge);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
