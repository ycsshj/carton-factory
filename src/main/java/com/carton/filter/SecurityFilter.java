package com.carton.filter;

import com.alibaba.fastjson.JSON;
import com.carton.model.User;
import com.carton.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-09-25 8:41
 ************************************************************/

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private Config config;

    private static String[] notFilter = null;

    @PostConstruct
    public void init() {
        loadConfig();
    }

    protected void loadConfig() {
        //权限过滤URI
        if (StringUtils.isNotEmpty(config.getIgnoreUrl())) {
            String str = config.getIgnoreUrl().replaceAll(StringPool.SPACE, StringPool.BLANK);
            notFilter = StringUtils.split(str, StringPool.COMMA);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (doValidate(request)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    private boolean doValidate(HttpServletRequest request) {
        boolean flag = false;
        boolean needFilter = needFilter(request.getRequestURI());
        if (needFilter) {

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
                        flag = true;
                    }
                }
            }else {
                flag = true;
            }
        } else {
            flag = true;
        }

        return flag;
    }

    protected boolean needFilter(String uri) {
        boolean doFilter = true;
        if (null == notFilter) {
            return true;
        }

        for (String s : notFilter) {
            if (uri.contains(s)) {
                doFilter = false;/**  如果uri中包含不过滤的uri，则不进行过滤 */
                break;
            }
        }
        return doFilter;
    }

}
