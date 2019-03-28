package net.chenlin.dp.modules.sc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScProviderEntity;
import net.chenlin.dp.modules.sc.dao.ScProviderMapper;
import net.chenlin.dp.modules.sc.service.ScProviderService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scProviderService")
public class ScProviderServiceImpl implements ScProviderService {

	@Autowired
    private ScProviderMapper scProviderMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScProviderEntity> listScProvider(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScProviderEntity> page = new Page<>(query);
		scProviderMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 列出所有
	 * @return
	 */
	@Override
	public List<ScProviderEntity> listAll(){
		return scProviderMapper.listAll();
	}

    /**
     * 新增
     * @param scProvider
     * @return
     */
	@Override
	public R saveScProvider(ScProviderEntity scProvider) {
		int count = scProviderMapper.save(scProvider);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScProviderById(Object id) {
		ScProviderEntity scProvider = scProviderMapper.getObjectById(id);
		return CommonUtils.msg(scProvider);
	}

//	/**
//	 * 根据id查询详情
//	 * @param id
//	 * @return
//	 */
//	@Override
//	public R getProviderByProviderId(String id) {
//		return scProviderMapper.getProviderByProviderId(id);
//	}

    /**
     * 修改
     * @param scProvider
     * @return
     */
	@Override
	public R updateScProvider(ScProviderEntity scProvider) {
		int count = scProviderMapper.update(scProvider);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scProviderMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
