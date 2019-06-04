package net.chenlin.dp.modules.sc.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScUploadEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScUploadMapper extends BaseMapper<ScUploadEntity> {

    /**
     * 获取实时数据
     * @param params
     * @return
     */
    List<ScUploadEntity> getRealTimeData(Map<String, Object> params);

}
