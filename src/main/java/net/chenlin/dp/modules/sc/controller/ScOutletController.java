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
import net.chenlin.dp.modules.sc.entity.ScOutletEntity;
import net.chenlin.dp.modules.sc.service.ScOutletService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/outlet")
public class ScOutletController extends AbstractController {
	
	@Autowired
	private ScOutletService scOutletService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScOutletEntity> list(@RequestBody Map<String, Object> params) {
		return scOutletService.listScOutlet(params);
	}

	/**
	 * 更改设备状态为启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/enable")
	public R enable(@RequestBody String id){
		ScOutletEntity scOutletEntity = new ScOutletEntity();
		scOutletEntity.setOutletid(id);
		scOutletEntity.setEnable(1);
		return scOutletService.updateScOutlet(scOutletEntity);
	}

	/**
	 * 更改设备状态为弃用
	 * @param id
	 * @return
	 */
	@RequestMapping("/disable")
	public R disable(@RequestBody String id){
		ScOutletEntity scOutletEntity = new ScOutletEntity();
		scOutletEntity.setOutletid(id);
		scOutletEntity.setEnable(0);
		return scOutletService.updateScOutlet(scOutletEntity);
	}
		
	/**
	 * 新增
	 * @param scOutlet
	 * @return
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ScOutletEntity scOutlet) {
		return scOutletService.saveScOutlet(scOutlet);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody String id) {
		return scOutletService.getScOutletById(id);
	}
	
	/**
	 * 修改
	 * @param scOutlet
	 * @return
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ScOutletEntity scOutlet) {
		return scOutletService.updateScOutlet(scOutlet);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody String[] id) {
		return scOutletService.batchRemove(id);
	}
	
}
