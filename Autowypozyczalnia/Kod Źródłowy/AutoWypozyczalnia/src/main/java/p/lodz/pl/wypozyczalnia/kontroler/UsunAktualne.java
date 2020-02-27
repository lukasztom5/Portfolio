package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import p.lodz.pl.dao.AktualneDaoImpl;

@WebServlet(name="UsunAktualne", urlPatterns={"/UsunAktualne"})
public class UsunAktualne extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idaktualneWypozyczenie = Integer.parseInt(request.getParameter("idaktualne_wypozyczenie"));
		
	AktualneDaoImpl adi=new AktualneDaoImpl();
	adi.removeById(idaktualneWypozyczenie);
	response.sendRedirect("KlientHistoriaWypozyczenAdmin.jsp");
	
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
