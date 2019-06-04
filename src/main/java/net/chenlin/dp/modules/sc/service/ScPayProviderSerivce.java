package net.chenlin.dp.modules.sc.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScPayProviderEntity;

import java.util.Map;

/**
 *
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScPayProviderSerivce {

    /**
     * 列表
     * @param params
     * @return
     */
    Page<ScPayProviderEntity> list(Map<String, Object> params);

    /**
     * 根据id获取账单
     * @param id
     * @return
     */
    ScPayProviderEntity getById(Object id);

    /**
     * 打款
     * @param scPayProviderEntity
     * @return
     */
    R pay(ScPayProviderEntity scPayProviderEntity);
}
