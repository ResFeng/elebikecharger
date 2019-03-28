package net.chenlin.dp.modules.sc.service;

import java.util.List;
import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScProviderEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScProviderService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScProviderEntity> listScProvider(Map<String, Object> params);

    /**
     * 列出所有
     * @return
     */
    List<ScProviderEntity> listAll();

    /**
     * 新增
     * @param scProvider
     * @return
     */
	R saveScProvider(ScProviderEntity scProvider);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScProviderById(Object id);

//    /**
//     * 根据id查询详情
//     * @param id
//     * @return
//     */
//    R getProviderByProviderId(String id);

    /**
     * 修改
     * @param scProvider
     * @return
     */
	R updateScProvider(ScProviderEntity scProvider);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
