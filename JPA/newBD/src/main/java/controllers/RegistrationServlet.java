package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 8/28/16.
 * artyom-karnov@yandex.ru
 **/
@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("RegistrationServlet initialization ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
