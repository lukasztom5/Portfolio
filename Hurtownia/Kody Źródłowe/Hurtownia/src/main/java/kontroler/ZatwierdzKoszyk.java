package kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ZatwierdzKoszyk", urlPatterns={"/ZatwierdzKoszyk"})
public class ZatwierdzKoszyk extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idzakup = Integer.parseInt(request.getParameter("idzakup"));
		
		request.getSession().setAttribute("idzakup", idzakup);
		response.sendRedirect("koszykszczegoly.jsp");
	
		
		
		
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
