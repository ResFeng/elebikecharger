package net.chenlin.dp.modules.sc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chenlin.dp.modules.sc.dao.ScProviderMapper;
import net.chenlin.dp.modules.sc.service.ScProviderService;
import net.chenlin.dp.modules.sys.dao.SysUserMapper;
import net.chenlin.dp.modules.sys.dao.SysUserRoleMapper;
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
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScOutletEntity> list(@RequestBody Map<String, Object> params) {
		Long roleId = sysUserRoleMapper.listUserRoleId(getUserId());
		if(roleId != 1){
			params.put("providerId", sysUserMapper.getObjectById(getUserId()).getProviderId());
		}else{
			params.put("providerId", null);
		}
		return scOutletService.listScOutlet(params);
	}

	/**
	 * 查询outlet
	 * @return
	 */
	@RequestMapping("/listOutlets")
	public List<ScOutletEntity> listOutlets(){
		Map<String, Object> params = new HashMap<>();
		Long roleId = sysUserRoleMapper.listUserRoleId(getUserId());
		if(roleId != 1){
			params.put("providerId", sysUserMapper.getObjectById(getUserId()).getProviderId());
		}else{
			params.put("providerId", null);
		}
		return scOutletService.listOutlets(params);
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
	 * 更改设备状态为下线
	 * @param id
	 * @return
	 */
	@RequestMapping("/offline")
	public R offline(@RequestBody String id){
		ScOutletEntity scOutletEntity = new ScOutletEntity();
		scOutletEntity.setOutletid(id);
		scOutletEntity.setIsonline(0);
		return scOutletService.updateScOutlet(scOutletEntity);
	}

	/**
	 * 更改设备状态为在线
	 * @param id
	 * @return
	 */
	@RequestMapping("/online")
	public R online(@RequestBody String id){
		ScOutletEntity scOutletEntity = new ScOutletEntity();
		scOutletEntity.setOutletid(id);
		scOutletEntity.setIsonline(1);
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
		id = id.replaceAll("\"", "");
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
