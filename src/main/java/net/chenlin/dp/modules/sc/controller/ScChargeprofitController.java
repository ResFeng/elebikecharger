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
import net.chenlin.dp.modules.sc.entity.ScChargeprofitEntity;
import net.chenlin.dp.modules.sc.service.ScChargeprofitService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/chargeprofit")
public class ScChargeprofitController extends AbstractController {
	
	@Autowired
	private ScChargeprofitService scChargeprofitService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScChargeprofitEntity> list(@RequestBody Map<String, Object> params) {
		return scChargeprofitService.listScChargeprofit(params);
	}
		
	/**
	 * 新增
	 * @param scChargeprofit
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScChargeprofitEntity scChargeprofit) {
		return scChargeprofitService.saveScChargeprofit(scChargeprofit);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scChargeprofitService.getScChargeprofitById(id);
	}
	
	/**
	 * 修改
	 * @param scChargeprofit
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScChargeprofitEntity scChargeprofit) {
		return scChargeprofitService.updateScChargeprofit(scChargeprofit);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scChargeprofitService.batchRemove(id);
	}
	
}
