package net.chenlin.dp.modules.sc.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class pathAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
/**
 * @Description: 對檔案的路徑進行配置,建立一個虛擬路徑/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用圖片
 *這是圖片的物理路徑 "file:/ 本地圖片的地址"
 * @Date： Create in 14:08 2017/12/20
 */   registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/CV/");
        super.addResourceHandlers(registry);
    }
}
