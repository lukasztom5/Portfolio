package kontroler;
import encje.Administrator;
import encje.Klient;
import encje.Pracownik;
import server.KlientLoginService;
import dao.AdministratorDaoImpl;
import dao.KlientDaoImpl;
import dao.PracownikDaoImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "KlientLogin", urlPatterns = { "/KlientLogin" })
public class KlientLogin extends HttpServlet {
	private static final long serialVersionUID = -9058829356528043636L;

	protected void processRequest(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	
	String login = request.getParameter("login");
	String haslo = request.getParameter("password");
	KlientLoginService kls= new KlientLoginService();
	boolean result=kls.login(login, haslo);
	boolean result1=kls.login1(login, haslo);
	boolean result2=kls.login2(login, haslo);
	AdministratorDaoImpl adi = new AdministratorDaoImpl();
	Administrator a=adi.findbylogin(login);
	PracownikDaoImpl pdi = new PracownikDaoImpl();
	Pracownik p=pdi.findbylogin(login);
	KlientDaoImpl kdi=new KlientDaoImpl();
	Klient kw= kdi.findbylogin(login);
	if (result == true) {
		request.getSession().setAttribute("admin", a);
		response.sendRedirect("adminmenu.jsp");
	}else if (result2 == true){
		
		request.getSession().setAttribute("klient", kw);
		response.sendRedirect("klientmenu.jsp");
	}else if (result1 == true){
		request.getSession().setAttribute("pracownik", p);
	    response.sendRedirect("pracownikmenu.jsp");
	
	}
	
	else { 
		response.sendRedirect("bladLogKlient.jsp");
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
