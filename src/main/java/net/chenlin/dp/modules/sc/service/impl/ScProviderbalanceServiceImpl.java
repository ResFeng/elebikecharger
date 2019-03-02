package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScProviderbalanceEntity;
import net.chenlin.dp.modules.sc.dao.ScProviderbalanceMapper;
import net.chenlin.dp.modules.sc.service.ScProviderbalanceService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scProviderbalanceService")
public class ScProviderbalanceServiceImpl implements ScProviderbalanceService {

	@Autowired
    private ScProviderbalanceMapper scProviderbalanceMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScProviderbalanceEntity> listScProviderbalance(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScProviderbalanceEntity> page = new Page<>(query);
		scProviderbalanceMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scProviderbalance
     * @return
     */
	@Override
	public R saveScProviderbalance(ScProviderbalanceEntity scProviderbalance) {
		int count = scProviderbalanceMapper.save(scProviderbalance);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScProviderbalanceById(Long id) {
		ScProviderbalanceEntity scProviderbalance = scProviderbalanceMapper.getObjectById(id);
		return CommonUtils.msg(scProviderbalance);
	}

    /**
     * 修改
     * @param scProviderbalance
     * @return
     */
	@Override
	public R updateScProviderbalance(ScProviderbalanceEntity scProviderbalance) {
		int count = scProviderbalanceMapper.update(scProviderbalance);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scProviderbalanceMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
