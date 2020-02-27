package kontroler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.*;
import server.*;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ZnajdzCzescPoCenachG",urlPatterns={"/ZnajdzCzescPoCenachG"})
public class ZnajdzCzescPoCenachG extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		
		ZnajdzCzescService zppz= new ZnajdzCzescService();
		List<Czesc> lista= new ArrayList<Czesc>();
	
	
		lista=zppz.findczescbycena(request.getParameter("cena1"), request.getParameter("cena2"),request.getParameter("id2"));
		
	if(lista.size()>0){
		request.getSession().setAttribute("lista", lista);
		response.sendRedirect("czescimodelwyszukane.jsp");
	}else{
		response.sendRedirect("brakczesci.jsp");
	}
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
