package com.by.leylo;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pathToThisServlet")
public class Servlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);

    private static final int FACTOR = 4;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Servlet#doPost() called");
        final String valueToMultiply = request.getParameter("valueToMultiply");
        LOGGER.info(valueToMultiply);
        final int number = Integer.parseInt(valueToMultiply);
        request.setAttribute("calculations", "Your calculations are: " + number + " * " + FACTOR + " = " + number*FACTOR);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Servlet#doPost() called");
        final String valueToMultiply = request.getParameter("valueToMultiply");
        LOGGER.info(valueToMultiply);
        response.setContentType("text/html");
        final int number = Integer.parseInt(valueToMultiply);
        response.getWriter().print("Simple GET. <br/>\nYour calculations are: " + number + " * " + FACTOR + " = " + number*FACTOR);
    }
}