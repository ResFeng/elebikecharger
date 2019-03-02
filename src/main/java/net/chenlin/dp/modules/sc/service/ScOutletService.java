package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScOutletEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScOutletService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScOutletEntity> listScOutlet(Map<String, Object> params);

    /**
     * 新增
     * @param scOutlet
     * @return
     */
	R saveScOutlet(ScOutletEntity scOutlet);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScOutletById(String id);

    /**
     * 修改
     * @param scOutlet
     * @return
     */
	R updateScOutlet(ScOutletEntity scOutlet);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(String[] id);
	
}
