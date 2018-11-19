package com.zhuhao.spring.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
       // registry.addViewController("zzzx").setViewName("success");
    }

    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/zzz").setViewName("index");
            }
        };
        return adapter;
    }*/

    /**
     * 添加视图解析器
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/dashboard.html").setViewName("dashboard.html");
    }

    /*
        注册拦截器
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //    /** 拦截项目路径下的所有请求 所有子请求  .excludePathPatterns 不需要拦截的页面
        //registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");
       // registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/dashboard.html");


      // registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/tologin","/webjars/**","/asserts/**");
        System.out.println("addUbterceotors已经加载啦------");
    }
}
