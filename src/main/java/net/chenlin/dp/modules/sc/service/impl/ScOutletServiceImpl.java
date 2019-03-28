package net.chenlin.dp.modules.sc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScOutletEntity;
import net.chenlin.dp.modules.sc.dao.ScOutletMapper;
import net.chenlin.dp.modules.sc.service.ScOutletService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scOutletService")
public class ScOutletServiceImpl implements ScOutletService {

	@Autowired
    private ScOutletMapper scOutletMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScOutletEntity> listScOutlet(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScOutletEntity> page = new Page<>(query);
		scOutletMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 查询outlet
	 * @param params
	 * @return
	 */
	@Override
	public List<ScOutletEntity> listOutlets(Map<String, Object> params){
		return scOutletMapper.listOutlets(params);
	}

    /**
     * 新增
     * @param scOutlet
     * @return
     */
	@Override
	public R saveScOutlet(ScOutletEntity scOutlet) {
		int count = scOutletMapper.save(scOutlet);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScOutletById(String id) {
		ScOutletEntity scOutlet = scOutletMapper.getObjectById(id);
		return CommonUtils.msg(scOutlet);
	}

    /**
     * 修改
     * @param scOutlet
     * @return
     */
	@Override
	public R updateScOutlet(ScOutletEntity scOutlet) {
		scOutlet.setOutletid(scOutlet.getOutletid().replaceAll("\"", ""));
		int count = scOutletMapper.update(scOutlet);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(String[] id) {
		int count = scOutletMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
