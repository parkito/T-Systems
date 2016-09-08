package controllers.admin;

import entities.TariffOption;
import services.implementation.TariffOptionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
public class ChangeTariffOptionServlet extends HttpServlet {
    TariffOptionServiceImpl tariffOptionService = new TariffOptionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession(true).setAttribute("options", tariffOptionService.getAll());
        req.getRequestDispatcher("/WEB-INF/admin/EditTariffOption.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tariffOptionId = Integer.parseInt(req.getParameter("options"));
        TariffOption tariffOption = tariffOptionService.getEntityById(tariffOptionId);
        tariffOptionService.deleteEntity(tariffOption);
    }
}
