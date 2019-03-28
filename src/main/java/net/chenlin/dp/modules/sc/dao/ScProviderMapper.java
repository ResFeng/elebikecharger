package net.chenlin.dp.modules.sc.dao;

import org.apache.ibatis.annotations.Mapper;

import net.chenlin.dp.modules.sc.entity.ScProviderEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;

import java.util.List;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Mapper
public interface ScProviderMapper extends BaseMapper<ScProviderEntity> {
    /**
     * 列出所有
     * @return
     */
    List<ScProviderEntity> listAll();

    /**
     * 获取运营商名
     * @param providerName
     * @return
     */
    String getProviderName(String providerName);
}
