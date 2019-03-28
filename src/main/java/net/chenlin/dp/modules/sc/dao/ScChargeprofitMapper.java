package net.chenlin.dp.modules.sc.dao;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScChargeprofitEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScChargeprofitMapper extends BaseMapper<ScChargeprofitEntity> {
    /**
     * 取出当日运营商收益
     * @param page
     * @param query
     * @return
     */
    List<ScChargeprofitEntity> getProfit(Page<ScChargeprofitEntity> page, Query query);
    /**
     * 列出当日运营商收益
     * @param page
     * @param query
     * @return
     */
    List<ScChargeprofitEntity> listProfit(Page<ScChargeprofitEntity> page, Query query);
    /**
     * 设备使用统计
     * @param page
     * @param query
     * @return
     */
    List<ScChargeprofitEntity> getProfitReport(Page<ScChargeprofitEntity> page, Query query);
}
