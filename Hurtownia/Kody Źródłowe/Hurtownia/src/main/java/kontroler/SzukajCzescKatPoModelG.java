package kontroler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.*;
import server.*;

@WebServlet(name=" SzukajCzescKatPoModelG",urlPatterns={"/ SzukajCzescKatPoModelG"})
public class SzukajCzescKatPoModelG extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String nazwa=request.getParameter("kategoria");
		ZnajdzCzescService zks=new ZnajdzCzescService();
		List<Czesc> lista= new ArrayList<Czesc>();
		if(id!=null && nazwa!=null)
			lista=zks.findczescbymodel(nazwa, id);
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
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
