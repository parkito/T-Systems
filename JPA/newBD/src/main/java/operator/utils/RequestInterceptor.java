package operator.utils;

import operator.entities.User;
import operator.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * An interceptor to log all the requests.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        long startTime = System.currentTimeMillis();
        String url = request.getRequestURL().toString();
        try {
            String userLogin = ((User) request.getSession().getAttribute("currentUserU")).getEmail();
            request.setAttribute("startTime", startTime);
        }
        //if returned false, we need to make sure 'response' is sent
        catch (Exception ex) {
            try {
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                User currentUser = userService.getUserByEMAil(user.getUsername());
                request.getSession().setAttribute("currentUserU", currentUser);
            } catch (Exception exception) {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Request URL::" + request.getRequestURL().toString()
                + " Sent to Handler");
        //we can add attributes in the modelAndView and use that in the view page
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
    }
}
