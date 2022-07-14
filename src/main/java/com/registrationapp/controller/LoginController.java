package com.registrationapp.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;
@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService dao= new DAOServiceImpl();//Child upcasting creating child object and storing in parent reference variable
		dao.connectDB();
		boolean status=dao.verifyCredentials(email, password);
		if(status==true) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
			rd.forward(request,response);//forward is used here because control goes to new page
		}else {
			request.setAttribute("error", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request,response);//use include here instead of forward because forward is used when we are in different page whereas include is used to remain in the same page
		}
		
	}
}
