package kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ZmienRezer", urlPatterns={"/ZmienRezer"})
public class ZmienRezer extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idaktualne_zamowienie = Integer.parseInt(request.getParameter("idaktualne_zamowienie"));
		
		request.getSession().setAttribute("idaktualne_zamowienie",idaktualne_zamowienie);
		response.sendRedirect("editrezer.jsp");
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
