import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.LogRecord;

/**
 * Created by Artyom Karnov on 8/27/16.
 * artyom-karnov@yandex.ru
 **/
public class FirstFilter implements Filter {
    Random random = new Random();

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
        PrintWriter out = response.getWriter();
        if (random.nextInt(100) % 2 == 0)
            out.print("<h1>You are not lucky this time. Please try again</h1>\n");
        else {
            if (random.nextInt(100) % 3 == 0)
                request.getRequestDispatcher("/?prize=money").forward(request, response);
            else if (random.nextInt(100) % 5 == 0)
                request.getRequestDispatcher("/?prize=car").forward(request, response);
            else request.getRequestDispatcher("/?prize=free bear").forward(request, response);
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }

    public boolean isLoggable(LogRecord record) {
        return false;
    }

}
