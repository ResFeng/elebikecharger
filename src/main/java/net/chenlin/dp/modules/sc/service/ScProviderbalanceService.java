package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScProviderbalanceEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScProviderbalanceService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScProviderbalanceEntity> listScProviderbalance(Map<String, Object> params);

    /**
     * 新增
     * @param scProviderbalance
     * @return
     */
	R saveScProviderbalance(ScProviderbalanceEntity scProviderbalance);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScProviderbalanceById(Long id);

    /**
     * 修改
     * @param scProviderbalance
     * @return
     */
	R updateScProviderbalance(ScProviderbalanceEntity scProviderbalance);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
