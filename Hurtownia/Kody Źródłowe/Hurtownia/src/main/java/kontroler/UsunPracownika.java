package kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

@WebServlet(name="UsunPracownika ", urlPatterns={"/UsunPracownika "})
public class UsunPracownika extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idprac = Integer.parseInt(request.getParameter("idpracownik"));
		
	PracownikDaoImpl kdi=new PracownikDaoImpl();
	RozliczenieDaoImpl rdi=new RozliczenieDaoImpl();
	rdi.removeByIdPrac(idprac);
	kdi.removeById(idprac);
	
	
	response.sendRedirect("pracownicy.jsp");
	
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
