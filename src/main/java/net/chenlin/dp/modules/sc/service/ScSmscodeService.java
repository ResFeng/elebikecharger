package net.chenlin.dp.modules.sc.service;

import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScSmscodeEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScSmscodeService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScSmscodeEntity> listScSmscode(Map<String, Object> params);

    /**
     * 新增
     * @param scSmscode
     * @return
     */
	R saveScSmscode(ScSmscodeEntity scSmscode);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScSmscodeById(Long id);

    /**
     * 修改
     * @param scSmscode
     * @return
     */
	R updateScSmscode(ScSmscodeEntity scSmscode);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
