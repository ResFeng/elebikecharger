package net.chenlin.dp.modules.sc.service;

import java.util.List;
import java.util.Map;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScUploadEntity;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface ScUploadService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<ScUploadEntity> listScUpload(Map<String, Object> params);

    /**
     * 获取实时数据
     * @param params
     * @return
     */
    List<ScUploadEntity> getRealTimeData(Map<String, Object> params);

    /**
     * 新增
     * @param scUpload
     * @return
     */
	R saveScUpload(ScUploadEntity scUpload);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getScUploadById(Long id);

    /**
     * 修改
     * @param scUpload
     * @return
     */
	R updateScUpload(ScUploadEntity scUpload);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
