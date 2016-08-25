package controllers;

import manipulating.ClientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class registration extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        System.out.println("processRequest");
        //System.out.println("work");
        if ("/registration".equals(userPath)) {
            //  System.out.println("yes");
//            ClientDAO clientDAO = new ClientDAO();
//            clientDAO.addClient(
//                    request.getParameter("name"),
//                    request.getParameter("secondName"),
//                    request.getParameter("birthdayDate"),
//                    request.getParameter("passport"),
//                    request.getParameter("adress"),
//                    request.getParameter("email"),
//                    request.getParameter("password")
//            );
        }


        request.getRequestDispatcher("/WEB-INF/views" + userPath + ".jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        ClientDAO clientDAO = new ClientDAO();
        String name = request.getParameter("name");
        String secondName = request.getParameter("secondName");
        String birthdayData = request.getParameter("birthdayData");
        String passport = request.getParameter("passport");
        String adress = request.getParameter("adress");
        String eMail = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(name + " " + secondName + " " + birthdayData + " " + " " + " " + passport + " " + adress + " " + eMail + password);
        clientDAO.addClient(
                name, secondName,
                birthdayData, passport,
                adress, eMail,
                password
        );
    }
    //processRequest(request, response);
//        System.out.println(request.getParameter("name") + " " +
//                request.getParameter("secondName") + " " +
//                request.getParameter("birthdayDate") + " " +
//                request.getParameter("passport") + " " +
//                request.getParameter("adress") + " " +
//                request.getParameter("email") + " " +
//                request.getParameter("password"));
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
