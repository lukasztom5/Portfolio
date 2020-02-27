package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Wypozycz", urlPatterns = { "/Wypozycz" })
public class Wypozycz extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String dodatek1 = request.getParameter("dodatek1");
		String dodatek2 = request.getParameter("dodatek2");
		String dodatek3 = request.getParameter("dodatek3");
		String dodatek4 = request.getParameter("dodatek4");
		String dodatek5 = request.getParameter("dodatek5");
		String dodatek6 = request.getParameter("dodatek6");
		
		String[] lista_dodatkow = { dodatek1, dodatek2, dodatek3,
				dodatek4, dodatek5, dodatek6 };
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
