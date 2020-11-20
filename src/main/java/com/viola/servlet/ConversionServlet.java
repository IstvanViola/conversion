package com.viola.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.viola.services.ConversionServiceImpl;

@WebServlet("/result")
public class ConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public ConversionServlet() {
        super();
    }
    
     
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
    	 
    	// get data from UI
    	 
     	String convertFrom = request.getParameter("convertFrom");
   		String convertTo = request.getParameter("convertTo");
   		int amount = Integer.parseInt(request.getParameter("amount"));
     		
   		
   		request.setAttribute("amount", amount);
   		request.setAttribute("convertFrom", convertFrom);
   		request.setAttribute("convertTo", convertTo);
   				
   		HttpSession session = request.getSession(true);   		
   		
   		ConversionServiceImpl service = new ConversionServiceImpl();
   		int result = 0;
  
   		// calculate the result 
   		
   		if("HUF".equals(convertFrom)) {
   			int sell = Integer.parseInt(request.getParameter("sell"));
 			result = service.ConversionConvertFromHUF(amount, sell);
   		} else if ("HUF".equals(convertTo)) {
   			int buy = Integer.parseInt(request.getParameter("buy"));
   			result = service.ConversionConvertToHUF(amount, buy);
   		} else {
   			int sell = Integer.parseInt(request.getParameter("sell"));
   			int buy = Integer.parseInt(request.getParameter("buy"));
 			result = service.Conversion(amount, buy, sell);
   		}

    
   		request.getSession().setAttribute("result", result);
  		response.sendRedirect("/result.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
