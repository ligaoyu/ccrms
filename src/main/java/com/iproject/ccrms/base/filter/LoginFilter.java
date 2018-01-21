package com.iproject.ccrms.base.filter;

import com.alibaba.fastjson.JSON;
import com.iproject.ccrms.base.constant.Constants;
import com.iproject.ccrms.base.enums.ResultEnum;
import com.iproject.ccrms.base.utils.ResultUtil;
import com.iproject.ccrms.token.service.TokenManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ligaoyu on 18/1/17.
 */
@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Autowired
    private TokenManagerService tokenManagerService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //排除登录API
        String url = request.getRequestURL().toString();
        String method = request.getMethod().toString();
        if(url.endsWith("/token/login") && "POST".equals(method)){
            filterChain.doFilter(request,response);
        }else{
            String token = request.getHeader(Constants.AUTHORIZATION);
            if(token == null){
                write(response,ResultUtil.error(ResultEnum.InvalidToken));
            }
            boolean flag  = tokenManagerService.checkToken(token);
            if(flag){
                filterChain.doFilter(request,response);
            }else{
                write(response,ResultUtil.error(ResultEnum.InvalidToken));
            }
        }
    }

    private void write(HttpServletResponse response,Object obj){
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.print(JSON.toJSON(obj));
        pw.close();
    }

    @Override
    public void destroy() {

    }

}
