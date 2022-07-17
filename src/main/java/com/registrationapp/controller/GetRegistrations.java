package com.registrationapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;
@WebServlet("/getRegistrations")
public class GetRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetRegistrations() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOService service= new DAOServiceImpl();//Child upcasting creating child object and storing in parent reference variable
		service.connectDB();
		
		ResultSet result = service.listAllReg();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request,response);//forward is used here because control goes to new page
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
