package net.chenlin.dp.modules.sc.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sc.entity.ScPriceEntity;
import net.chenlin.dp.modules.sc.dao.ScPriceMapper;
import net.chenlin.dp.modules.sc.service.ScPriceService;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("scPriceService")
public class ScPriceServiceImpl implements ScPriceService {

	@Autowired
    private ScPriceMapper scPriceMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<ScPriceEntity> listScPrice(Map<String, Object> params) {
		Query query = new Query(params);
		Page<ScPriceEntity> page = new Page<>(query);
		scPriceMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param scPrice
     * @return
     */
	@Override
	public R saveScPrice(ScPriceEntity scPrice) {
		int count = scPriceMapper.save(scPrice);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getScPriceById(Long id) {
		ScPriceEntity scPrice = scPriceMapper.getObjectById(id);
		return CommonUtils.msg(scPrice);
	}

    /**
     * 修改
     * @param scPrice
     * @return
     */
	@Override
	public R updateScPrice(ScPriceEntity scPrice) {
		int count = scPriceMapper.update(scPrice);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = scPriceMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
