package net.chenlin.dp.modules.sc.controller;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScPayProviderEntity;
import net.chenlin.dp.modules.sc.service.ScPayProviderSerivce;
import net.chenlin.dp.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 * @author ZhouChenglin<yczclcn@163.com>
 */
@RestController
@RequestMapping("/sc/payprovider")
public class ScPayProviderController extends AbstractController {

    @Autowired
    private ScPayProviderSerivce scPayProviderSerivce;

    /**
     * 列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<ScPayProviderEntity> list(@RequestBody Map<String, Object> params) {
        return scPayProviderSerivce.list(params);
    }

    /**
     * 根据id获取账单
     * @param id
     * @return
     */
    @RequestMapping("/getById")
    public ScPayProviderEntity getById(@RequestBody Object id){
        return scPayProviderSerivce.getById(id);
    }

    /**
     * 打款
     * @param scPayProviderEntity
     * @return
     */
    @RequestMapping("/pay")
    public R list(@RequestBody ScPayProviderEntity scPayProviderEntity) {
        return scPayProviderSerivce.pay(scPayProviderEntity);
    }
}
