package net.chenlin.dp.modules.sc.controller;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sc.entity.ScUserEntity;
import net.chenlin.dp.modules.sc.service.ScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sc/user")
public class ScUserController {

    @Autowired
    private ScUserService scUserService;

    /**
     * 列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<ScUserEntity> list(@RequestBody Map<String, Object> params) {
        return scUserService.listForPage(params);
    }

    /**
     * 新增
     * @param scUser
     * @return
     */
    @SysLog("新增")
    @RequestMapping("/save")
    public R save(@RequestBody ScUserEntity scUser) {
        return scUserService.save(scUser);
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R getById(@RequestBody Long id) {
        System.out.println(id);
        return scUserService.getObjectById(id);
    }

    /**
     * 修改
     * @param scUser
     * @return
     */
    @SysLog("修改")
    @RequestMapping("/update")
    public R update(@RequestBody ScUserEntity scUser) {
        return scUserService.update(scUser);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @SysLog("删除")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return scUserService.batchRemove(id);
    }
}
