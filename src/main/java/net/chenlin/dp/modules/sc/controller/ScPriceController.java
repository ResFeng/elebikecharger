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
import net.chenlin.dp.modules.sc.entity.ScPriceEntity;
import net.chenlin.dp.modules.sc.service.ScPriceService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/price")
public class ScPriceController extends AbstractController {
	
	@Autowired
	private ScPriceService scPriceService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScPriceEntity> list(@RequestBody Map<String, Object> params) {
		return scPriceService.listScPrice(params);
	}
		
	/**
	 * 新增
	 * @param scPrice
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScPriceEntity scPrice) {
		return scPriceService.saveScPrice(scPrice);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scPriceService.getScPriceById(id);
	}
	
	/**
	 * 修改
	 * @param scPrice
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScPriceEntity scPrice) {
		return scPriceService.updateScPrice(scPrice);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scPriceService.batchRemove(id);
	}
	
}
