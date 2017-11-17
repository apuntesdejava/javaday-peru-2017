package com.apuntesdejava.servlet4;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 *
 * @author diego
 */
@WebServlet(urlPatterns = {"/push_servlet/*"})
public class ExamplePushServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PushBuilder pushBuilder = req.newPushBuilder();
        if (pushBuilder != null) {
            pushBuilder.path("/images/logo.png").push();
            pushBuilder.path("/js/test.js").push();
        }
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/html/view.html");
        rd.include(req, resp);
    }

}
