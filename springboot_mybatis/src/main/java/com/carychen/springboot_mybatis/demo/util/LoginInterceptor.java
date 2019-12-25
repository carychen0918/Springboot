package com.carychen.springboot_mybatis.demo.util;

import com.carychen.springboot_mybatis.demo.entity.user_info;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by chentao
 * Date by 2019-12-03
 * 无敌太寂寞
 */

public class LoginInterceptor implements HandlerInterceptor {
    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
        System.out.println("进入拦截器");
        //这里的User是登陆时放入session的
        user_info user = (user_info) session.getAttribute("user_info");
        //如果session中没有user，表示没登陆
        String url = request.getRequestURI();
        System.out.println("请求路径"+url);
//        if(url.indexOf("/Cary")>-1||url.indexOf("/user/CancellationLogin")>-1){
//            return  true;
//        }
//        if (user == null){
//            //这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
//            //当然你可以利用response给用户返回一些提示信息，告诉他没登陆
//            response.sendRedirect("/Cary");
//            return false;
//        }else {
//            return true;    //如果session里有user，表示该用户已经登陆，放行，用户即可继续调用自己需要的接口
//        }
        return  true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }


}
