package controllers;

import entities.Contract;
import entities.User;
import services.implementation.ContractServiceImpl;
import services.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Artyom Karnov on 9/1/16.
 * artyom-karnov@yandex.ru
 **/
public class NumberOperationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eMail = "";
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("eMail")) eMail = cookie.getValue();
        }
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByEMAil(eMail);
        req.setAttribute("userObj", user);
        String userName = user.getName();
        req.setAttribute("userName", userName);
        ContractServiceImpl contractService = new ContractServiceImpl();
        List<Contract> contracts = contractService.getAllContractsForUser(user.getUserId());
        req.setAttribute("contracts", contracts);
        req.getRequestDispatcher("/WEB-INF/user/NumberOperations.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");
        System.out.println(req.getParameter("blockItem"));
        System.out.println(req.getParameter("unblockItem"));
        System.out.println(req.getAttribute("buffer"));
    }
}
