package controllers;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/9/16.
 * artyom-karnov@yandex.ru
 **/
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getAttribute("userName"));
    }

    @Override
    public void destroy() {

    }
}
