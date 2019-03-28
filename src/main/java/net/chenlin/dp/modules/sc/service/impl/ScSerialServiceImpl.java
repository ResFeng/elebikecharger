package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScSerialEntity;
import net.chenlin.dp.modules.sc.dao.ScSerialMapper;
import net.chenlin.dp.modules.sc.service.ScSerialService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scSerialService")
public class ScSerialServiceImpl implements ScSerialService {

	@Autowired
    private ScSerialMapper scSerialMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScSerialEntity> listScSerial(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScSerialEntity> page = new Page<>(query);
		scSerialMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 根据outletid列出
	 * @param params
	 * @return
	 */
	@Override
	public Page<ScSerialEntity> listByOutletId(Map<String, Object> params){
		Query query = new Query(params);
		Page<ScSerialEntity> page = new Page<>(query);
		scSerialMapper.listByOutletId(page, query);
		return page;
	}

	/**
	 * 列出正在充电的端口
	 * @param params
	 * @return
	 */
	@Override
	public Page<ScSerialEntity> listChargingSerial(Map<String, Object> params){
		Query query = new Query(params);
		Page<ScSerialEntity> page = new Page<>(query);
		scSerialMapper.listChargingSerial(page, query);
		return page;
	}

    /**
     * 新增
     * @param scSerial
     * @return
     */
	@Override
	public R saveScSerial(ScSerialEntity scSerial) {
		int count = scSerialMapper.save(scSerial);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScSerialById(Long id) {
		ScSerialEntity scSerial = scSerialMapper.getObjectById(id);
		return CommonUtils.msg(scSerial);
	}

    /**
     * 修改
     * @param scSerial
     * @return
     */
	@Override
	public R updateScSerial(ScSerialEntity scSerial) {
		int count = scSerialMapper.update(scSerial);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scSerialMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
