package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.dao.AutoDaoImpl;

@WebServlet(name="UsunAuto", urlPatterns={"/UsunAuto"})
public class UsunAuto extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idauto = Integer.parseInt(request.getParameter("idauto"));
		
	AutoDaoImpl adi=new AutoDaoImpl();
	adi.removeById(idauto);
	response.sendRedirect("auta.jsp");
	
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
