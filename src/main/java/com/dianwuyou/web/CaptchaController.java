package com.dianwuyou.web;

import com.dianwuyou.model.json.AjaxResponseBody;
import com.dianwuyou.util.Constants;
import com.dianwuyou.util.Encoding;
import com.google.code.kaptcha.Producer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Random;

/**
 * Created by hebowei on 16/6/10.
 */
@Controller
@RequestMapping("/verify")
public class CaptchaController {

    private Producer captchaProducer;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception{
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = captchaProducer.createText();

        // store the text in the session
        request.getSession().setAttribute(Constants.KEY_CAPTCHA_SESSION, capText);

        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();

        // write the data out
        ImageIO.write(bi, "jpg", out);
        try
        {
            out.flush();
        }
        finally
        {
            out.close();
        }
        return null;
    }

    public static boolean testCaptcha(String userInput, HttpServletRequest request){
        String sessionCaptcha = (String) request.getSession().getAttribute(Constants.KEY_CAPTCHA_SESSION);
        if(null == sessionCaptcha)
            return false;
        sessionCaptcha = sessionCaptcha.toLowerCase();
        userInput = userInput.toLowerCase();
        return userInput.equals(sessionCaptcha);
    }

    /**
     * 校验图片验证码
     * 会删除session中的验证码字段
     * @param map
     *              {captcha: REQUEST_CAPTCHA}
     * @param request
     * @return
     *  状态码:
     *      200 - 校验成功, 会生成一个token用于下一步操作
     *      400 - 校验失败
     *      401 - 输入错误
     */
    @ResponseBody
    @RequestMapping(value = "/img", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody verifyImgCaptcha(@RequestBody Map<String, String> map,
                                             HttpServletRequest request){
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(map.containsKey("captcha")){
            if(testCaptcha(map.get("captcha"), request)){
                String token = Encoding.getRandomUUID();
                request.getSession().setAttribute(Constants.KEY_CAPTCHA_SUCC_TOKEN,
                        token);
                responseBody.setState(200);
                responseBody.setContent(token);
            } else {
                responseBody.setState(400);
            }
        } else {
            responseBody.setState(401);
        }

        request.getSession().removeAttribute(Constants.KEY_CAPTCHA_SESSION);
        return responseBody;
    }

    /**
     * 发送校验码短信
     * 会预先判断session中存的图片验证码正确性,校验后删除图片验证码session
     * 发送成功后在session中写入md5(手机号+校验码)
     * @param map
     *          {phone: REQUEST_PHONE_NUMBER, token: TOKEN}
     * @param request
     * @return
     *  状态码:
     *      200 - 发送成功，返回一个随机值作为token
     *      403 - 鉴权失败
     *
     */
    @ResponseBody
    @RequestMapping(value = "/phone", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody sentVerifySms(@RequestBody Map<String, String> map,
                                          HttpServletRequest request){
        //TODO: 短信验证码服务接入
        AjaxResponseBody responseBody = new AjaxResponseBody();
        String tokenInSession = (String)request.getSession().getAttribute(Constants.KEY_CAPTCHA_SUCC_TOKEN);
        boolean succFlag = false;
        if(tokenInSession != null && map.containsKey("token") && map.containsKey("phone")){
            if(tokenInSession.equals(map.get("token"))){
                //鉴权成功
                //TODO: Send Sms
                String debugSmsCode = "1234";
                String sessionToken = Encoding.getEncodedString(map.get("phone") + debugSmsCode);
                request.getSession().setAttribute(Constants.KEY_MOBILE_PHONE, sessionToken);
                String randToken = Encoding.getRandomUUID();
                request.getSession().setAttribute(Constants.KEY_CAPTCHA_SUCC_TOKEN, randToken);
                succFlag = true;
                responseBody.setState(200);
                responseBody.setContent(randToken);
            }
        }
        if(!succFlag){
            responseBody.setState(403);
            request.getSession().removeAttribute(Constants.KEY_CAPTCHA_SUCC_TOKEN);
        }

        return responseBody;
    }
}