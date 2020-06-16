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
        final String strategy = request.getParameter("strategy");
        LOGGER.info("strategy is : " + strategy);
        if (strategy.equals("postMultiply")) {
            multiplyPost(request, response);
        } else if (strategy.equals("sendEmail")) {
            sendEmail(request, response);
        }
    }

    private void sendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String subject = request.getParameter("subject");
        final String text = request.getParameter("text");
        LOGGER.info("Sender: [" + email + "], subject: [" + subject + "], text: [" + text + "].");

        boolean isSuccessfullySent = sendEmail(email, subject, text);

        request.setAttribute("isEmailSend", isSuccessfullySent);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private boolean sendEmail(String email, String subject, String text) {
        boolean isSent = true;
        // stub
        // write the email processor service to process emails

        // now we act like every time we successfully send emails
        return isSent;
    }

    private void multiplyPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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