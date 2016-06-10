package com.dianwuyou.web;

import com.dianwuyou.model.User;
import com.dianwuyou.service.UserService;
import com.dianwuyou.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hebowei on 16/6/9.
 */
@Component
@ComponentScan("com.dianwuyou")
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int state = userService.maintainLoginState(request, response);
        if(state >= 0) {
            return true;
        }
        else{
            response.sendRedirect(request.getContextPath() + "/user/login?next=" + request.getRequestURI() + "&state=" + state);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            Integer uid = (Integer) request.getSession().getAttribute(Constants.KEY_USER_UID);
            if(uid == null){
                modelAndView.getModel().put("loginState", false);
            } else {
                User user = userService.findById(uid);
                String displayName = user.getEmail();
                modelAndView.getModel().put("loginState", true);
                modelAndView.getModel().put("displayName", displayName);
            }
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
