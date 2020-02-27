package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AktualneInfoAdmin", urlPatterns={"/AktualneInfoAdmin"})
public class AktualneInfoAdmin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idaktualneWypozyczenie = Integer.parseInt(request.getParameter("idaktualne_wypozyczenie"));
		
		request.getSession().setAttribute("idaktualne_wypozyczenie", idaktualneWypozyczenie);
		response.sendRedirect("historiaAdminInfo.jsp");
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
