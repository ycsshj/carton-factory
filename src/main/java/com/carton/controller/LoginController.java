package com.carton.controller;

import com.alibaba.fastjson.JSON;
import com.carton.model.User;
import com.carton.service.UserService;
import com.carton.util.AESUtil;
import com.carton.util.Context;
import com.carton.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-25 8:46
 ************************************************************/

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLoginPage(HttpServletRequest request, Model model) {

        Object userString = request.getSession().getAttribute(Context.USER_INFO);
        User user = JSON.parseObject(String.valueOf(userString), User.class);
        if (user == null) {
            Cookie recordCookie = CookieUtil.getCookieByName(request, Context.USER_INFO);
            if (recordCookie != null && StringUtils.isNotBlank(recordCookie.getValue())) {
                String decrypt = AESUtil.decrypt(recordCookie.getValue(), Context.AES_KEY);
                user = JSON.parseObject(decrypt, User.class);

                if (user != null) {
                    request.getSession().setAttribute(Context.USER_INFO, JSON.toJSONString(user));
                    request.getSession().setAttribute(Context.USER_NAME, user.getUserName());
                    return "redirect:/home";
                }
            }
        }else {
            return "redirect:/home";
        }

        /*Cookie recordCookie = CookieUtil.getCookieByName(request, Context.USER_INFO);
        if (recordCookie != null) {
            String decrypt = AESUtil.decrypt(recordCookie.getValue(), Context.AES_KEY);
            User user = JSON.parseObject(decrypt, User.class);

            model.addAttribute("userName", user.getUserName());
            model.addAttribute("passWord", AESUtil.decrypt(user.getPassword(), Context.AES_KEY));
            model.addAttribute("remember", true);
        }*/

        return "login/sign-in";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@RequestParam String userName,
                          @RequestParam String passWord,
                          @RequestParam(required = false) boolean remember,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          Model model) {

        User user = userService.validateUser(userName, AESUtil.encrypt(passWord, Context.AES_KEY));
        if (user != null) {

            //cookie中记住用户名密码, 加密的方式
            if (remember) {
                CookieUtil.setCookie(response, Context.USER_INFO, AESUtil.encrypt(JSON.toJSONString(user), Context.AES_KEY), 24 * 60 * 60);
            }

            request.getSession().setAttribute(Context.USER_INFO, JSON.toJSONString(user));
            request.getSession().setAttribute(Context.USER_NAME, user.getUserName());
            return "redirect:/home";
        }

        model.addAttribute("message", "用户名或密码错误, 请重新登录");
        return  "login/sign-in";
    }

    @RequestMapping("/home")
    public String index() {
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie killUserCookie = new Cookie(Context.USER_INFO, null);
        killUserCookie.setMaxAge(0);
        killUserCookie.setPath("/");
        response.addCookie(killUserCookie);

        return "redirect:/login";
    }

}
