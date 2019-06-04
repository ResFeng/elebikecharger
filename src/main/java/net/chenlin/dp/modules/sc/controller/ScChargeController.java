package net.chenlin.dp.modules.sc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScChargeEntity;
import net.chenlin.dp.modules.sc.service.ScChargeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/charge")
public class ScChargeController extends AbstractController {
	
	@Autowired
	private ScChargeService scChargeService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScChargeEntity> list(@RequestBody Map<String, Object> params) {
		return scChargeService.listScCharge(params);
	}

	/**
	 * 获取端口使用统计
	 * @param params
	 * @return
	 */
	@RequestMapping("/getSerialReport")
	public List<ScChargeEntity> getSerialReport(@RequestBody Map<String, Object> params){
		return scChargeService.getSerialReport(params);
	}
		
	/**
	 * 新增
	 * @param scCharge
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScChargeEntity scCharge) {
		return scChargeService.saveScCharge(scCharge);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scChargeService.getScChargeById(id);
	}
	
	/**
	 * 修改
	 * @param scCharge
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScChargeEntity scCharge) {
		return scChargeService.updateScCharge(scCharge);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scChargeService.batchRemove(id);
	}
	
}
