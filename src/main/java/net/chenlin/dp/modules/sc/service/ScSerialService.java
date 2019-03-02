package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScSerialEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScSerialService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScSerialEntity> listScSerial(Map<String, Object> params);

    /**
     * 新增
     * @param scSerial
     * @return
     */
	R saveScSerial(ScSerialEntity scSerial);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScSerialById(Long id);

    /**
     * 修改
     * @param scSerial
     * @return
     */
	R updateScSerial(ScSerialEntity scSerial);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
