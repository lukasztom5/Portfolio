package kontroler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.Pracownik;
import server.ZnajdzPracownikaService;

@WebServlet(name="ZnajdzPracownika",urlPatterns={"/ZnajdzPracownika"})
public class ZnajdzPracownika extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String ida=request.getParameter("ida");
		String imie=request.getParameter("imie");
		String nazwisko=request.getParameter("nazwisko");
		String kraj=request.getParameter("kraj");
		String miasto=request.getParameter("miasto");

		
		ZnajdzPracownikaService zks=new ZnajdzPracownikaService();
		List<Pracownik> lista= new ArrayList<Pracownik>();
		if(id!=null)
			lista=zks.findpracownikbycolumn("ID",id);
		if(ida!=null)
			lista=zks.findpracownikbycolumn("IDADMINISTRATOR",ida);
		else if(nazwisko!=null)
			lista=zks.findpracownikbycolumn("NAZWISKO",nazwisko);
		else if(imie!=null)
			lista=zks.findpracownikbycolumn("IMIE",imie);
		else if(kraj!=null)
			lista=zks.findpracownikbycolumn("KRAJ",kraj);
		else if(miasto!=null)
			lista=zks.findpracownikbycolumn("MIASTO",miasto);
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
