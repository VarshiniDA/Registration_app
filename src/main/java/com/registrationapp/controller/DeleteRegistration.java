package com.registrationapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;
@WebServlet("/delete")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteRegistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if (session.getAttribute("email")!=null){
			String email = request.getParameter("emailId");
			DAOService service = new DAOServiceImpl();
			service.connectDB();
			service.deleteByEmailId(email);
			
			ResultSet result = service.listAllReg();
			
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
			rd.forward(request,response);//forward is used here because control goes to new page
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			rd.forward(request,response);//forward is used here because control goes to new page
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
