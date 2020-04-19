//package com.haotian.consumer.Component;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//
//        Object account = request.getSession().getAttribute("user");
//        System.out.println("account"+account);
//        if (account == null || account.equals(""))  {
//            response.sendRedirect("/index.html");
//            return false;
//        }
//        return true;
//    }
//}
