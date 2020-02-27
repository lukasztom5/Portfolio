package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AutoInfo", urlPatterns={"/AutoInfo"})
public class AutoInfo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idauto = Integer.parseInt(request.getParameter("idauto"));
		
		request.getSession().setAttribute("idauto", idauto);
		response.sendRedirect("autoInfo.jsp");
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
