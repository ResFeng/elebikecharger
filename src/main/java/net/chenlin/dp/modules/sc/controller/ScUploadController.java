package net.chenlin.dp.modules.sc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScUploadEntity;
import net.chenlin.dp.modules.sc.service.ScUploadService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/upload")
public class ScUploadController extends AbstractController {
	
	@Autowired
	private ScUploadService scUploadService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScUploadEntity> list(@RequestBody Map<String, Object> params) {
		return scUploadService.listScUpload(params);
	}
		
	/**
	 * 新增
	 * @param scUpload
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScUploadEntity scUpload) {
		return scUploadService.saveScUpload(scUpload);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scUploadService.getScUploadById(id);
	}
	
	/**
	 * 修改
	 * @param scUpload
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScUploadEntity scUpload) {
		return scUploadService.updateScUpload(scUpload);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scUploadService.batchRemove(id);
	}
	
}
