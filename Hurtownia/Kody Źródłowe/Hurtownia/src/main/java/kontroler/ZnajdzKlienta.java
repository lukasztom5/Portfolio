package kontroler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.Klient;
import server.ZnajdzKlientaService;

@WebServlet(name="ZnajdzKlienta",urlPatterns={"/ZnajdzKlienta"})
public class ZnajdzKlienta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String nazwisko=request.getParameter("nazwisko");
		String imie=request.getParameter("imie");
		String kraj=request.getParameter("kraj");
		String miasto=request.getParameter("miasto");
		String zaklad=request.getParameter("zaklad");
		
		ZnajdzKlientaService zks=new ZnajdzKlientaService();
		List<Klient> lista= new ArrayList<Klient>();
		if(id!=null)
			lista=zks.findklientbycolumn("ID",id);
		else if(nazwisko!=null)
			lista=zks.findklientbycolumn("NAZWISKO",nazwisko);
		else if(imie!=null)
			lista=zks.findklientbycolumn("IMIE",imie);
		else if(kraj!=null)
			lista=zks.findklientbycolumn("KRAJ",kraj);
		else if(miasto!=null)
			lista=zks.findklientbycolumn("MIASTO",miasto);
		else if(zaklad!=null)
			lista=zks.findklientbycolumn("ZAKLAD",zaklad);
		if(lista.size()>0){
			request.getSession().setAttribute("lista", lista);
			response.sendRedirect("klienciwyszukani.jsp");
		}else{
			response.sendRedirect("brakklientow.jsp");
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
