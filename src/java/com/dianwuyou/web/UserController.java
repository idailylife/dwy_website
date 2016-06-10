package com.dianwuyou.web;

import com.dianwuyou.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hebowei on 16/6/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户登录,GET请求
     * @param model
     * @param next
     * @param state
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model,
                            @RequestParam(value = "next", required = false) String next,
                            @RequestParam(value = "state", required = false) String state,
                            HttpServletRequest request){
        if(request.getSession().getAttribute(Constants.KEY_USER_UID) != null){
            //用户已经登录,跳转至主页
            return "redirect:/";
        }

        if(next != null){
            model.addAttribute("nextUrl", next);
        } else {
            model.addAttribute("nextUrl", request.getContextPath());
        }
        if(state != null){
            model.addAttribute("state", state);
        }
        return "user/login";
    }

    /**
     * 注册新用户,GET请求
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister(HttpServletRequest request){
        if(request.getSession().getAttribute(Constants.KEY_USER_UID) != null){
            return "redirect:/";
        }
        return "user/register";
    }
}
