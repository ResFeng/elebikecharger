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
import net.chenlin.dp.modules.sc.entity.ScRechargeEntity;
import net.chenlin.dp.modules.sc.service.ScRechargeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/recharge")
public class ScRechargeController extends AbstractController {
	
	@Autowired
	private ScRechargeService scRechargeService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScRechargeEntity> list(@RequestBody Map<String, Object> params) {
		return scRechargeService.listScRecharge(params);
	}
		
	/**
	 * 新增
	 * @param scRecharge
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScRechargeEntity scRecharge) {
		return scRechargeService.saveScRecharge(scRecharge);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scRechargeService.getScRechargeById(id);
	}
	
	/**
	 * 修改
	 * @param scRecharge
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScRechargeEntity scRecharge) {
		return scRechargeService.updateScRecharge(scRecharge);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scRechargeService.batchRemove(id);
	}
	
}
