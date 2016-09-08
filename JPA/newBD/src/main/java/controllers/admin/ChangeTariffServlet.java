package controllers.admin;

import entities.Tariff;
import services.implementation.TariffOptionServiceImpl;
import services.implementation.TariffServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artyom Karnov on 9/8/16.
 * artyom-karnov@yandex.ru
 **/
public class ChangeTariffServlet extends HttpServlet {
    TariffServiceImpl tariffService = new TariffServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession(true).setAttribute("tariffs", tariffService.getAll());
        req.getRequestDispatcher("/WEB-INF/admin/EditTariff.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tariffId = Integer.parseInt(req.getParameter("tariffId"));
        Tariff tariff = tariffService.getEntityById(tariffId);
        tariffService.deleteEntity(tariff);
    }
}
