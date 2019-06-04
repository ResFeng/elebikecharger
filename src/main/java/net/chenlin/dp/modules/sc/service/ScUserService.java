package net.chenlin.dp.modules.sc.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScUserEntity;

import java.util.List;
import java.util.Map;

public interface ScUserService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<ScUserEntity> listForPage(Map<String, Object> params);

    /**
     * 新增
     * @param scUser
     * @return
     */
    R save(ScUserEntity scUser);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    R getObjectById(Long id);

    /**
     * 修改
     * @param scUser
     * @return
     */
    R update(ScUserEntity scUser);

    /**
     * 删除
     * @param id
     * @return
     */
    R batchRemove(Long[] id);
}
