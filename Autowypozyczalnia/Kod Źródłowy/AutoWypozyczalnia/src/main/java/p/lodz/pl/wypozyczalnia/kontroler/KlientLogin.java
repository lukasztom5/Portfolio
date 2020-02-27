package p.lodz.pl.wypozyczalnia.kontroler;
import p.lodz.pl.encje.Klient;
import p.lodz.pl.serwer.KlientLoginService;
import p.lodz.pl.dao.KlientDaoImpl;

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
	
	String idklient = request.getParameter("idklient");
	String login = request.getParameter("login");
	String haslo = request.getParameter("password");
	KlientLoginService kls= new KlientLoginService();
	boolean result=kls.login(Integer.parseInt(idklient), login, haslo);
	KlientDaoImpl kdi=new KlientDaoImpl();
	Klient klient=kdi.findById(Integer.parseInt(idklient));
	if (result == true) {
		request.getSession().setAttribute("klient", klient);
		response.sendRedirect("klientmenu.jsp");
	} else { 
		request.getSession().setAttribute("klient", null);
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
