package net.chenlin.dp.modules.sc.dao;

import net.chenlin.dp.modules.sc.entity.ScPayProviderEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ScPayProviderMapper extends BaseMapper<ScPayProviderEntity> {
    /**
     * 根据id获取账单
     * @param id
     * @return
     */
    ScPayProviderEntity getById(Object id);

    /**
     * 根据providerId payMonth 获取Id
     * @param params
     * @retrun
     */
    int getId(Map<String, Object> params);
}
