package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScOutlettypeEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScOutlettypeService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScOutlettypeEntity> listScOutlettype(Map<String, Object> params);

    /**
     * 新增
     * @param scOutlettype
     * @return
     */
	R saveScOutlettype(ScOutlettypeEntity scOutlettype);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScOutlettypeById(Long id);

    /**
     * 修改
     * @param scOutlettype
     * @return
     */
	R updateScOutlettype(ScOutlettypeEntity scOutlettype);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
