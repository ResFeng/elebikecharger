package net.chenlin.dp.modules.sc.dao;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScSerialEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScSerialMapper extends BaseMapper<ScSerialEntity> {

    /**
     * 分页查询列表
     * @param page
     * @param query
     * @return
     */
    List<ScSerialEntity> listByOutletId(Page<ScSerialEntity> page, Query query);
    /**
     * 列出正在充电的端口
     * @param page
     * @param query
     * @return
     */
    Page<ScSerialEntity> listChargingSerial(Page<ScSerialEntity> page, Query query);
	
}
