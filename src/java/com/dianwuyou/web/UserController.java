package com.dianwuyou.web;

import com.dianwuyou.model.User;
import com.dianwuyou.model.json.AjaxResponseBody;
import com.dianwuyou.util.Constants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

    /**
     * AJAX注册用户请求,json数据
     *
     * @param user
     * @param bindingResult
     * @param request
     * @return
     * 状态码:
     *  400 - 表单验证错误
     *  401 - Email重复
     *  403 - 尚未通过图片/短信校验
     *  200 - 注册成功
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody register(@RequestBody @Valid User user, BindingResult bindingResult,
                                     HttpServletRequest request){
        AjaxResponseBody responseBody = new AjaxResponseBody();
        //TODO: Impl
        return responseBody;
    }

}
