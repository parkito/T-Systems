import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.logging.LogRecord;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class FirstFilter implements Filter {
    public void init(FilterConfig config)
            throws ServletException {
        String testParam = config.getInitParameter("test-param");
        config.getServletContext();
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        req.setAttribute("prize", "23");
        HttpServletRequestWrapper newRequst = new HttpServletRequestWrapper(req);
        
        System.out.println(newRequst.getParameter("prize"));
        chain.doFilter(request, response);
    }

    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }

    public boolean isLoggable(LogRecord record) {
        return false;
    }

}
