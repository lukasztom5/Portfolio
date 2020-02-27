package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.dao.KlientDaoImpl;
import p.lodz.pl.serwer.KlientRegistryService;
import p.lodz.pl.encje.Klient;

public class KlientRegistry extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		String imie=request.getParameter("imie");
		String nazwisko=request.getParameter("nazwisko");
		String pesel=request.getParameter("pesel");
		String miasto=request.getParameter("miasto");
		String adres=request.getParameter("adres");
		String adresMail=request.getParameter("adres_mail");
		String telefon=request.getParameter("telefon");
		String login=request.getParameter("login");
		String haslo=request.getParameter("haslo");
		KlientDaoImpl kdi=new KlientDaoImpl();
		Integer idklient=kdi.NewIdKlient();
		Klient klient= new Klient(idklient, imie, nazwisko, pesel, miasto, adres, adresMail, telefon, login, haslo);
		try{
			KlientRegistryService krs=new KlientRegistryService();
			boolean r=krs.rejestracja(klient);
			if(r){
				request.getSession().setAttribute("idklient", idklient.toString());
				response.sendRedirect("RejestracjaPoprawna.jsp");
			}
			else {

				response.sendRedirect("bladrejestracja.jsp");
			}
		}finally{
			pw.close();
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
