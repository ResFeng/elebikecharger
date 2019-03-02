package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScPriceEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScPriceService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScPriceEntity> listScPrice(Map<String, Object> params);

    /**
     * 新增
     * @param scPrice
     * @return
     */
	R saveScPrice(ScPriceEntity scPrice);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScPriceById(Long id);

    /**
     * 修改
     * @param scPrice
     * @return
     */
	R updateScPrice(ScPriceEntity scPrice);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
