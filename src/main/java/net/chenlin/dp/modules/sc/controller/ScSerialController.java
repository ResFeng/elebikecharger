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
import net.chenlin.dp.modules.sc.entity.ScSerialEntity;
import net.chenlin.dp.modules.sc.service.ScSerialService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/serial")
public class ScSerialController extends AbstractController {
	
	@Autowired
	private ScSerialService scSerialService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScSerialEntity> list(@RequestBody Map<String, Object> params) {
		return scSerialService.listScSerial(params);
	}
		
	/**
	 * 新增
	 * @param scSerial
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScSerialEntity scSerial) {
		return scSerialService.saveScSerial(scSerial);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scSerialService.getScSerialById(id);
	}
	
	/**
	 * 修改
	 * @param scSerial
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScSerialEntity scSerial) {
		return scSerialService.updateScSerial(scSerial);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scSerialService.batchRemove(id);
	}
	
}
