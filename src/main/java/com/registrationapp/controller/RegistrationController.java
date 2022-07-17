package com.registrationapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;
@WebServlet("/registrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
		rd.forward(request,response);//forward is used here because control goes to new page
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if (session.getAttribute("email")!=null) {
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			DAOService service= new DAOServiceImpl();//Child upcasting creating child object and storing in parent reference variable
			service.connectDB();
			
			service.saveRegistration(name,city,email,mobile);
			
			request.setAttribute("msg", "Record Saved");	
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
			rd.include(request, response);//include is used here because we are redirecting to the same page
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			rd.forward(request,response);
		}
	}

}
