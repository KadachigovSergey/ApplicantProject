package org.sourceit.main;

import org.sourceit.util.Chooser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class Controller extends HttpServlet {

    private Chooser chooser = Chooser.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("ffa");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("ffs");
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("1");
        try {
            System.out.printf("2");
            String page = chooser.chooseCommand(req.getParameter("command")).execute(req, resp);
            System.out.printf("3");
            req.getRequestDispatcher(page).forward(req, resp);
            System.out.printf("4");
        } catch (ServletException | IOException e) {
            System.out.printf("5");
            e.printStackTrace();
        }
    }
}
