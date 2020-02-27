package kontroler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.Pracownik;
import server.ZnajdzPracownikaService;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ZnajdzPracownikaPoZarobkach",urlPatterns={"/ZnajdzPracownikaPoZarobkach"})
public class ZnajdzPracownikaPoZarobkach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		
	ZnajdzPracownikaService zppz= new ZnajdzPracownikaService();
	List<Pracownik> lista= new ArrayList<Pracownik>();
	
	
		lista=zppz.findpracownikbypensje(request.getParameter("pensja1"), request.getParameter("pensja2"));
		
	if(lista.size()>0){
		request.getSession().setAttribute("lista", lista);
		response.sendRedirect("pracownicywyszukani.jsp");
	}else{
		response.sendRedirect("brakpracownikow.jsp");
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
