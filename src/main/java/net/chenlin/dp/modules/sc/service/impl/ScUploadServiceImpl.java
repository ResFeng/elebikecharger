package net.chenlin.dp.modules.sc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScUploadEntity;
import net.chenlin.dp.modules.sc.dao.ScUploadMapper;
import net.chenlin.dp.modules.sc.service.ScUploadService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scUploadService")
public class ScUploadServiceImpl implements ScUploadService {

	@Autowired
    private ScUploadMapper scUploadMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScUploadEntity> listScUpload(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScUploadEntity> page = new Page<>(query);
		scUploadMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 获取实时数据
	 * @param params
	 * @return
	 */
	@Override
	public List<ScUploadEntity> getRealTimeData(Map<String, Object> params){
		return scUploadMapper.getRealTimeData(params);
	}

    /**
     * 新增
     * @param scUpload
     * @return
     */
	@Override
	public R saveScUpload(ScUploadEntity scUpload) {
		int count = scUploadMapper.save(scUpload);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScUploadById(Long id) {
		ScUploadEntity scUpload = scUploadMapper.getObjectById(id);
		return CommonUtils.msg(scUpload);
	}

    /**
     * 修改
     * @param scUpload
     * @return
     */
	@Override
	public R updateScUpload(ScUploadEntity scUpload) {
		int count = scUploadMapper.update(scUpload);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scUploadMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
