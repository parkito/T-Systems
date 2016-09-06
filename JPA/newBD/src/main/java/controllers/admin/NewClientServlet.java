package controllers.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/6/16.
 * artyom-karnov@yandex.ru
 **/
public class NewClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/NewClient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String secondNam = req.getParameter("surName");
        String birthdayData= req.getParameter("birthday");
        String passport= req.getParameter("passport");
        String adress= req.getParameter("adress");
        String email= req.getParameter("email");
        String password= req.getParameter("password");


    }
}
