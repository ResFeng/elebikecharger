package net.chenlin.dp.modules.sc.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScOutletEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScOutletMapper extends BaseMapper<ScOutletEntity> {
    /**
     * 查询outlet
     * @param params
     * @return
     */
    List<ScOutletEntity> listOutlets(Map<String, Object> params);
}
