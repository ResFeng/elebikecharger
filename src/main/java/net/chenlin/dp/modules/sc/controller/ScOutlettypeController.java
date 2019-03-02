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
import net.chenlin.dp.modules.sc.entity.ScOutlettypeEntity;
import net.chenlin.dp.modules.sc.service.ScOutlettypeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/outlettype")
public class ScOutlettypeController extends AbstractController {
	
	@Autowired
	private ScOutlettypeService scOutlettypeService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScOutlettypeEntity> list(@RequestBody Map<String, Object> params) {
		return scOutlettypeService.listScOutlettype(params);
	}
		
	/**
	 * 新增
	 * @param scOutlettype
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScOutlettypeEntity scOutlettype) {
		return scOutlettypeService.saveScOutlettype(scOutlettype);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scOutlettypeService.getScOutlettypeById(id);
	}
	
	/**
	 * 修改
	 * @param scOutlettype
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScOutlettypeEntity scOutlettype) {
		return scOutlettypeService.updateScOutlettype(scOutlettype);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scOutlettypeService.batchRemove(id);
	}
	
}
