package servlets;

import controllers.UserCases;
import services.implementation.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/13/16.
 * artyom-karnov@yandex.ru
 **/
public class AccessControlFilter implements Filter {
    private UserServiceImpl userService;

    public boolean isManager(String eMail) {
        return userService.getUserByEMAil(eMail).getAccessLevel() != null ? true : false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserServiceImpl();
    }

    /**
     * Controlling for users access
     *
     * @param servletRequest  servlet request
     * @param servletResponse servlet response
     * @param filterChain     next filter
     * @throws IOException      if something goes wrong with I/O operations
     * @throws ServletException if somthing goes wrong with servlet mechanism
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("/index.jsp");
        }
        String eMail = (String) session.getAttribute("eMail");
        boolean status = request.getRequestURL().substring(21).contains("admin");
        if (!isManager(eMail) && status)
            response.sendRedirect("/404.jsp");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
