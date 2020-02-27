package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.dao.AktualneDaoImpl;

@WebServlet(name = "AnulujWypozyczenie", urlPatterns = { "/AnulujWypozyczenie" })
public class AnulujWypozyczenie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("cancel") != null) {
			String idaktualne_wypozyczenie = (String) request.getSession().getAttribute("idaktualne_wypozyczenie");
			String idhistoria_wypozyczenia = (String) request.getSession().getAttribute("idhistoria_wypozyczenia");
			
			AktualneDaoImpl adi= new AktualneDaoImpl();
			adi.removeById(Integer.parseInt(idaktualne_wypozyczenie));
			
			HistoriaDaoImpl hdi= new HistoriaDaoImpl();
			hdi.removeById(Integer.parseInt(idhistoria_wypozyczenia));
			 
			response.sendRedirect("wolneauta.jsp");
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