package com.zhuhao.spring.configure;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 登录检查 ，没有登录的用户，无法进入后台
 */
public class LoginHandlerInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginuser");
        if(user == null){
            request.setAttribute("err","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            //System.out.println("拦截啦-----------------");
            return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
