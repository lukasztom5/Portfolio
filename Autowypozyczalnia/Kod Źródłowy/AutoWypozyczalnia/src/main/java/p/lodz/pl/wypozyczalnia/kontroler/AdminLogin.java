package p.lodz.pl.wypozyczalnia.kontroler;
import p.lodz.pl.encje.Administrator;
import p.lodz.pl.serwer.AdminLoginService;
import p.lodz.pl.dao.AdministratorDaoImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminLogin", urlPatterns = { "/AdminLogin" })
public class AdminLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String idadministrator =request.getParameter("idadministrator");
		String login =request.getParameter("login");
		String haslo =request.getParameter("password");
		AdminLoginService als= new AdminLoginService();
		boolean result=als.login(Integer.parseInt(idadministrator), login, haslo);
		AdministratorDaoImpl adi = new AdministratorDaoImpl();
		Administrator admin=adi.findById(Integer.parseInt(idadministrator));
		if(result==true){
			request.getSession().setAttribute("admin", admin);
		    response.sendRedirect("menuadmin.jsp");
		}
		else{
			request.getSession().setAttribute("admin", null);
		    response.sendRedirect("bladLogAdmin.jsp");
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
