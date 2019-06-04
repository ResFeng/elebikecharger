package net.chenlin.dp.modules.sc.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScChargeEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScChargeMapper extends BaseMapper<ScChargeEntity> {
    /**
     * 获取端口使用统计
     * @param params
     * @return
     */
    List<ScChargeEntity> getSerialReport(Map<String, Object> params);
	
}
