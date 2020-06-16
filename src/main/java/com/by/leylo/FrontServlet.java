package com.by.leylo;

import org.apache.log4j.Logger;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pathToThisServlet")
public class FrontServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);
    private static final int FACTOR = 4;

    // Find your Account Sid and Auth Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "your_auth_token";
    private static final String FROM_NUMBER = "+15017250604"; // example
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Servlet#doPost() called");
        final String strategy = request.getParameter("strategy");
        LOGGER.info("strategy is : " + strategy);
        if (strategy.equals("postMultiply")) {
            multiplyPost(request, response);
        } else if (strategy.equals("sendSMS")) {
            sendSMS(request, response);
        }
    }

    private void sendSMS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isSuccessfullySent = false;
        final String toPhoneNumber = request.getParameter("toPhoneNumber");
        final String text = request.getParameter("text");
        LOGGER.info("Phone number: [" + toPhoneNumber + "], text: [" + text + "].");
        try {
            final Message message = Message
                    .creator(new PhoneNumber("+" + toPhoneNumber), new PhoneNumber(FROM_NUMBER), text)
                    .create();
            LOGGER.info(message.getSid());
            isSuccessfullySent = message.getStatus().equals(Message.Status.SENT);
        } catch (Exception e) {
            LOGGER.info("Exception while sending SMS, " + e.toString());
        }
        request.setAttribute("isSent", isSuccessfullySent);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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