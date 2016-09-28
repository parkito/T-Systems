package operator.servlets.admin;

import operator.entities.TariffOption;
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
public class DeleteImOptionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();
        req.getSession(true).setAttribute("options", tariffOptionService.getAllImpossibleTariffOption(0));
        req.getRequestDispatcher("/WEB-INF/admin/adminDeleteImOptions.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

        int tariffOptionId = Integer.parseInt(req.getParameter("tariffOptionId"));
        TariffOption tariffOption = tariffOptionService.getEntityById(tariffOptionId);
        tariffOptionService.deleteEntity(tariffOption);
    }
}
