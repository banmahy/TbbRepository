package com.yehy.tbbserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Author yehy
 * @Date 2022/9/12 21:14
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${attachment.path}")
    private String attachmentPath;

    /**
     * 配置资源映射
     * 如果访问的资源路径以/images/开头的，直接映射到本机的docPath的文件夹中寻找资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:"+attachmentPath+"\\");
    }
}
