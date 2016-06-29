package com.dianwuyou.web;

import com.dianwuyou.model.User;
import com.dianwuyou.service.UserService;
import com.dianwuyou.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hebowei on 16/6/9.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        userService.maintainLoginState(request, response);
        Integer uid =  (Integer) request.getSession().getAttribute(Constants.KEY_USER_UID);
        userService.loginStateParse(model, uid);
        return "home";
    }
}
