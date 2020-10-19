package org.example.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthAcceptLanguage implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("In AuthAcceptLanguage");

        HttpServletRequest castedRequest = (HttpServletRequest) request;
        String authHeader = castedRequest.getHeader("Accept-Language");
        if (StringUtils.isNotBlank(authHeader)) { //for future JWT Token Auth
            System.out.println("Header In AuthAcceptLanguage was found with payload: " + authHeader);
        } else {
            System.out.println("Header In AuthAcceptLanguage was not found!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error500");
            System.out.println("Forward will be done");

        }
        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
