package com.dianwuyou.web;

import com.dianwuyou.model.User;
import com.dianwuyou.model.UserValdation;
import com.dianwuyou.model.json.AjaxResponseBody;
import com.dianwuyou.model.json.LoginRequestBody;
import com.dianwuyou.model.json.UserRequestBody;
import com.dianwuyou.service.UserService;
import com.dianwuyou.util.Constants;
import com.dianwuyou.util.Encoding;
import com.dianwuyou.util.Misc;
import com.dianwuyou.web.exception.ModelObjectNotFoundException;
import com.sun.tools.internal.jxc.ap.Const;
import com.sun.tools.internal.ws.wsdl.document.Binding;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by hebowei on 16/6/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
     * 处理用户登录请求：JSON
     * {
     *     email: 邮箱,
     *     password: md5(密码),
     *     captcha: 图片验证码
     * }
     * @param loginRequestBody
     * @param request
     * @return AjaxResponseBody
     * 状态码:
     *      200 - 成功
     *      400 - 请求格式错误
     *      401 - 图片验证码不匹配
     *      403 - 鉴权失败
     *      500 - 服务器内部错误
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody userLogin(@RequestBody @Valid LoginRequestBody loginRequestBody,
                                      BindingResult bindingResult,
                                      HttpServletRequest request, HttpServletResponse response){
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(bindingResult.hasErrors()){
            responseBody.setState(400);
            responseBody.setContent(Misc.parseBindingFieldErrors(bindingResult).toString());
            return responseBody;
        }
//        if(!Constants.DEBUG && !CaptchaController.testCaptcha(loginRequestBody.getCaptcha(),request)){
//            responseBody.setState(401);
//            responseBody.setMessage("Wrong captcha");
//            request.getSession().removeAttribute(Constants.KEY_CAPTCHA_SESSION);
//            return responseBody;
//        }
        // Un-comment above code to enable captcha check
        int checkState = userService.verify(loginRequestBody.getEmail(), loginRequestBody.getPassword());
        switch (checkState) {
            case UserService.ERR_WRONG_PASSWORD:
                User currUser = userService.findByEmail(loginRequestBody.getEmail());
                currUser.setToken("");    //Clear token
                userService.updateUser(currUser);
            case UserService.ERR_NO_SUCH_USER:
                responseBody.setState(403);
                responseBody.setMessage("Wrong email or password.");
                break;
            case UserService.ERR_SALT_UNDEFINED:
                responseBody.setState(500);
                responseBody.setMessage("Internal error: salt not defined.");
                break;
            case UserService.SUCC_LOGIN:
                responseBody.setState(200);
                //在cookie及session中写入id及token_cookie
                currUser = userService.findByEmail(loginRequestBody.getEmail());
                currUser.setToken(Encoding.getRandomUUID());
                userService.updateUser(currUser);
                request.getSession().setAttribute(Constants.KEY_USER_UID, currUser.getId());

                if(loginRequestBody.getRemember() != null &&
                        loginRequestBody.getRemember()){
                    String contextPath = request.getContextPath();
                    if(contextPath.length() < 1){
                        contextPath = "/";
                    }
                    Cookie uidCookie = new Cookie(Constants.KEY_USER_UID, currUser.getId().toString());
                    uidCookie.setMaxAge(7 * 24 * 3600); //7days
                    uidCookie.setPath(contextPath);
                    response.addCookie(uidCookie);
                    Cookie tokenCookie = new Cookie(Constants.KEY_USER_TOKEN, currUser.getToken());
                    tokenCookie.setMaxAge(7 * 24 * 3600);
                    tokenCookie.setPath(contextPath);
                    response.addCookie(tokenCookie);
                }

                break;
            default:
                responseBody.setState(500);
                responseBody.setMessage("Unknown state, internal error.");
        }
        return responseBody;
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
     * AJAX注册用户请求,json string:
     *                      `JSON.stringify(jsonObj)`
     *
     * 注册验证流程:
     * 1. (见CaptchaController)图片校验码显示、验证 --> token1
     * 2. (见CaptchaController)token1-->发短信验证码-->token2
     * 3. token2 --> 此处 --> 数据库写入
     *
     * Request格式:
     * {
     *     type: 用户类型，0-requester, 1-worker
     *     email: 邮箱,
     *     password: md5(密码),
     *     phoneNumber: 手机号,
     *     taobaoId: 淘宝账号, 可选,
     *     inviteCode: 邀请码, 可选,
     *     verifyCode: 短信验证码,
     *     token: 上一次请求成功返回的token
     * }
     *
     * 此方法校验
     *   1. session中存储的值与md5(手机号+验证码)
     *   2. token(校验手机号的时候给的)
     *
     * @param requestBody
     * @param bindingResult
     * @param request
     * @return
     * 状态码:
     *  400 - 表单验证错误
     *  401 - Email重复
     *  403 - 鉴权失败
     *  200 - 注册成功
     */
    @Transactional
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody register(@RequestBody @Valid UserRequestBody requestBody, BindingResult bindingResult,
                                     HttpServletRequest request){
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(bindingResult.hasErrors()) {
            responseBody.setState(400);
            responseBody.setMessage("Request contains errors");
            JSONArray errFields = Misc.parseBindingFieldErrors(bindingResult);
            responseBody.setContent(errFields.toString());
            return responseBody;
        } else if (!requestBody.isEmailValid()){
            responseBody.setState(400);
            responseBody.setMessage("Request contains errors");
            responseBody.setContent("[\"email\"]");
        }
        String sessionToken = (String)request.getSession().getAttribute(Constants.KEY_CAPTCHA_SUCC_TOKEN);
        String sessionMPhone = (String)request.getSession().getAttribute(Constants.KEY_MOBILE_PHONE);
        if(sessionMPhone == null || sessionToken == null
                || (!requestBody.getToken().equals(sessionToken))
                || (!sessionMPhone.equals(Encoding.getEncodedString(requestBody.getPhoneNumber()
                                    + requestBody.getVerifyCode() ))) ){
            responseBody.setState(403);
            responseBody.setMessage("Authorization failed");
            if(!Constants.DEBUG)
                return responseBody;
        }
        User user = new User();
        user.setEmail(requestBody.getEmail());
        user.setTaobaoId(requestBody.getTaobaoId());
        user.setPassword(requestBody.getPassword());
        userService.setSaltPassword(user);
        user.setPhoneNumber(requestBody.getPhoneNumber());
        user.setType(requestBody.getType());
        if(requestBody.getInviteCode() != null && requestBody.getInviteCode().length()>0){
            //TODO: (使用消息)记录积分变更
            User inviter = userService.findByInviteCode(requestBody.getInviteCode());
            if(inviter != null){
                user.setInviter(inviter.getId());
                if(user.getType() == User.USERTYPE_WORKER){
                    //推广worker注册加积分
                    inviter.setScore(inviter.getScore() + Constants.SCORE_INVITE_WORKER);
                    userService.updateUser(inviter);
                }
            }
        }
        userService.saveUser(user);
        responseBody.setState(200);
        return responseBody;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = userService.getFromSession(request);
        if(user != null){
            user.setToken(null);
            userService.updateUser(user);
            request.getSession().removeAttribute(Constants.KEY_USER_UID);
            Cookie uidCookie = new Cookie(Constants.KEY_USER_UID, null);
            uidCookie.setPath(request.getContextPath());
            uidCookie.setMaxAge(0);
            Cookie tokenCookie = new Cookie(Constants.KEY_USER_TOKEN, null);
            tokenCookie.setMaxAge(0);
            tokenCookie.setPath(request.getContextPath());
            response.addCookie(uidCookie);
            response.addCookie(tokenCookie);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

    /**
     * 用户实名认证(GET)
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verifyUser(HttpServletRequest request, Model model){
        User user = userService.getFromSession(request);
        model.addAttribute("user", user);
        return "user/verify";
    }

    @ResponseBody
    @RequestMapping(value = "/verify", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody submitUserVerify(@Valid UserValdation userValdation,
                                             BindingResult bindingResult,
                                             HttpServletRequest request)
    throws IOException, SQLException{
        AjaxResponseBody responseBody = new AjaxResponseBody();
        User user = userService.getFromSession(request);
        if(user == null){
          responseBody.setState(403);
        } else if(bindingResult.hasErrors()){
            responseBody.setState(400);
            //TODO: return error fields
        } else {
            user.fillPersionInfo(userValdation);
            userService.updateUser(user);
            responseBody.setState(200);
        }
        return responseBody;
    }

}
