package com.viola.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viola.model.GetRates;
import com.viola.dao.GetRateDAO;


@WebServlet("/get_rate")
public class GetRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		listGetRate(request, response);
        
    }

	public void listGetRate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GetRateDAO dao = new GetRateDAO();
      
        List<GetRates> listGetRate = dao.list();
		request.setAttribute("listGetRate", listGetRate);
 
		RequestDispatcher dispatcher = request.getRequestDispatcher("GetRate.jsp");
		dispatcher.forward(request, response);
    }
	
	// set values and forward to jsp
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		int id;
		String currency;
		int sell;
		int buy;
		
		if(request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("getRate"));	
		} else {
			id = 1;
		}
		
		if (request.getParameter("currency") != null) {
			currency = request.getParameter("currency");
		} else {
			currency = "CAD";
		}
		
		if (request.getParameter("sell") != null) {
			sell = Integer.parseInt(request.getParameter("sell"));
		} else {
			sell = 1;
		}

		if (request.getParameter("buy") != null) {
			buy = Integer.parseInt(request.getParameter("buy"));
		} else {
			buy = 1;
		}
		
 
        request.setAttribute("id", id);
        request.setAttribute("currency", currency);
        request.setAttribute("sell", sell);
        request.setAttribute("buy", buy);
          
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
    }
		
	
}
