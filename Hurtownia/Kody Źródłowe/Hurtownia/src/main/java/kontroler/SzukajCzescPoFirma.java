package kontroler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.*;
import server.*;

@WebServlet(name="SzukajCzescPoFirma",urlPatterns={"/SzukajCzescPoFirma"})
public class SzukajCzescPoFirma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		ZnajdzCzescService zks=new ZnajdzCzescService();
		List<Czesc> lista= zks.findczescbyfirma(request.getParameter("id"), request.getParameter("firma"));
		System.out.println(lista.size());
		if(lista.size()>0){
			request.getSession().setAttribute("lista", lista);
			response.sendRedirect("czescikategoriawyszukaneklient.jsp");
		}else{
			response.sendRedirect("brakczesciklient.jsp");
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
