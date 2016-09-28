package operator.servlets.admin;

import operator.entities.User;
import operator.exceptions.UserNotFoundException;
import operator.services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/12/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Servlet for find client controlling
 */
public class FindClientByEmailServlet extends HttpServlet {
    public static int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (count == 1) {
            req.getSession(true).setAttribute("check", "start");
            count++;
        }
        req.getRequestDispatcher("/WEB-INF/admin/adminViewClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        req.getSession(true).setAttribute("check", "work");
        UserServiceImpl userService = new UserServiceImpl();
        try {
            User user = userService.getUserByEMAil(email);
            req.getSession(true).setAttribute("usrs", user);

        } catch (UserNotFoundException ex) {
            req.getSession(true).setAttribute("usrs", null);
        }
    }
}
