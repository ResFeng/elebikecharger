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
import net.chenlin.dp.modules.sc.entity.ScProviderbalanceEntity;
import net.chenlin.dp.modules.sc.service.ScProviderbalanceService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/providerbalance")
public class ScProviderbalanceController extends AbstractController {
	
	@Autowired
	private ScProviderbalanceService scProviderbalanceService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScProviderbalanceEntity> list(@RequestBody Map<String, Object> params) {
		return scProviderbalanceService.listScProviderbalance(params);
	}
		
	/**
	 * 新增
	 * @param scProviderbalance
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScProviderbalanceEntity scProviderbalance) {
		return scProviderbalanceService.saveScProviderbalance(scProviderbalance);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scProviderbalanceService.getScProviderbalanceById(id);
	}
	
	/**
	 * 修改
	 * @param scProviderbalance
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScProviderbalanceEntity scProviderbalance) {
		return scProviderbalanceService.updateScProviderbalance(scProviderbalance);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scProviderbalanceService.batchRemove(id);
	}
	
}
