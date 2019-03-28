package net.chenlin.dp.modules.sc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.chenlin.dp.modules.sc.dao.ScProviderMapper;
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
import net.chenlin.dp.modules.sc.entity.ScProviderEntity;
import net.chenlin.dp.modules.sc.service.ScProviderService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/provider")
public class ScProviderController extends AbstractController {
	
	@Autowired
	private ScProviderService scProviderService;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private ScProviderMapper scProviderMapper;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<ScProviderEntity> list(@RequestBody Map<String, Object> params) {
		return scProviderService.listScProvider(params);
	}

	/**
	 * 列出所有
	 * @return
	 */
	@RequestMapping("/listAll")
	public List<ScProviderEntity> listAll(){
		Long roleId = sysUserRoleMapper.listUserRoleId(getUserId());
		if(roleId != 1){
			List<ScProviderEntity> scProviderEntities = new ArrayList<>();
			String providerId = sysUserMapper.getObjectById(getUserId()).getProviderId();
			ScProviderEntity scProviderEntity = new ScProviderEntity();
			scProviderEntity.setProviderid(providerId);
			scProviderEntity.setProvidername(scProviderMapper.getProviderName(providerId));
			scProviderEntities.add(scProviderEntity);
			return scProviderEntities;
		}else{
			return scProviderService.listAll();
		}
	}
		
	/**
	 * 新增
	 * @param scProvider
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody ScProviderEntity scProvider) {
		return scProviderService.saveScProvider(scProvider);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Object id) {
		return scProviderService.getScProviderById(id);
	}

//	/**
//	 * 根据providerId查询详情
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping("/info")
//	public R getProviderByProviderId(@RequestBody String id) {
//		return scProviderService.getProviderByProviderId(id);
//	}
	
	/**
	 * 修改
	 * @param scProvider
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody ScProviderEntity scProvider) {
		return scProviderService.updateScProvider(scProvider);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return scProviderService.batchRemove(id);
	}
	
}
