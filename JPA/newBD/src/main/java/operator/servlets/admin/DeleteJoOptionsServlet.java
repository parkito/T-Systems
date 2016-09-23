package operator.servlets.admin;

import operator.services.implementation.TariffOptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/14/16.
 * artyom-karnov@yandex.ru
 **/
public class DeleteJoOptionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.getSession(true).setAttribute("options", tariffOptionService.getAllJoinedTariffOption(0));
        req.getRequestDispatcher("/WEB-INF/admin/DeleteJoOptions.jsp").forward(req, resp);
    }
}
