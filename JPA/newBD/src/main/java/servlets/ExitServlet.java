package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/7/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for user exit controlling
 */
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).removeAttribute("userName");
        req.getSession(true).removeAttribute("tariffOptionService");
        req.getSession(true).removeAttribute("eMail");
        req.getSession(true).removeAttribute("contracts");
        req.getSession(true).removeAttribute("tariffService");
        req.getSession(true).removeAttribute("userObj");
        req.getSession(false).invalidate();
        resp.sendRedirect("/index.jsp");
    }

}
