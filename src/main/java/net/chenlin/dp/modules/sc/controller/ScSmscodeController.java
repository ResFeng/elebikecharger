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
import net.chenlin.dp.modules.sc.entity.ScSmscodeEntity;
import net.chenlin.dp.modules.sc.service.ScSmscodeService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/smscode")
public class ScSmscodeController extends AbstractController {
	
	@Autowired
	private ScSmscodeService scSmscodeService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScSmscodeEntity> list(@RequestBody Map<String, Object> params) {
		return scSmscodeService.listScSmscode(params);
	}
		
	/**
	 * 新增
	 * @param scSmscode
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScSmscodeEntity scSmscode) {
		return scSmscodeService.saveScSmscode(scSmscode);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return scSmscodeService.getScSmscodeById(id);
	}
	
	/**
	 * 修改
	 * @param scSmscode
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScSmscodeEntity scSmscode) {
		return scSmscodeService.updateScSmscode(scSmscode);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scSmscodeService.batchRemove(id);
	}
	
}
