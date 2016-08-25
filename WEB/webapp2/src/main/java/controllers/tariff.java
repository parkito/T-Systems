package controllers;

import manipulating.ClientDAO;
import manipulating.TariffDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Artyom Karnov on 8/25/16.
 * artyom-karnov@yandex.ru
 **/
@WebServlet(name = "tariff", urlPatterns = {"/tariff"})
public class tariff extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();
        System.out.println(userPath);
        PrintWriter out = response.getWriter();
        TariffDAO tariffDAO = new TariffDAO();
        out.write("<html>");
        out.write("<body>");
        out.write("Arr");
        tariffDAO.getTariffList();
        out.write("Arr");
        out.write("</body>");
        out.write("</html>");
//        request.getRequestDispatcher("/WEB-INF/views" + userPath + ".jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post");
    }
}
