package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HistoriaKlientInfo", urlPatterns={"/HistoriaKlientInfo"})
public class HistoriaKlientInfo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idhistoria_wypozyczenia = Integer.parseInt(request.getParameter("idhistoria_wypozyczenia"));
		
		request.getSession().setAttribute("idhistoria_wypozyczenia", idhistoria_wypozyczenia);
		response.sendRedirect("klientwypozyczInfo.jsp");
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
