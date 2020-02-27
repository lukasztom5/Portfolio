package kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorDaoImpl;
import dao.KlientDaoImpl;
import dao.PracownikDaoImpl;
import encje.Administrator;
import encje.Klient;
import encje.Pracownik;
import server.KlientModifyService;

@WebServlet(name = "KlientModifyKlient", urlPatterns = { "/KlientModifyKlient" })
public class KlientModifyKlient extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Klient kd=(Klient)request.getSession().getAttribute("KLIENT");
		String id=request.getParameter("id");
		System.out.println(id);
		String imie=request.getParameter("imie");
		String nazwisko=request.getParameter("nazwisko");
		String kraj=request.getParameter("kraj");
		String miasto=request.getParameter("miasto");
		String zaklad=request.getParameter("zaklad");
		String adres=request.getParameter("adres");
		String adres_mail=request.getParameter("adres_mail");
		String telefon=request.getParameter("telefon");
		String dane="<klient><idklient id=\""+Integer.parseInt(id)+"\">"+Integer.parseInt(id)
				+"<kod kod=\""+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "+request.getParameter("login")+"\">"
				+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "+request.getParameter("login")
				+ "</kod></idklient>"
				+ "<kraj country=\""+kraj+"\">"+kraj
				+ "<miasto city=\""+miasto+"\">"+miasto
				+ "<zaklad zak=\""+zaklad+"\">"+zaklad
						+ "<adres adr=\""+adres+"\">"+adres
								+ "</adres></zaklad></miasto></kraj>"
								+ "<nazwisko surname=\""+nazwisko+"\">"+nazwisko
										+ "<imie name=\""+imie+"\">"+imie
										+"</imie></nazwisko>"
										+"<adres_mail am=\""+adres_mail+"\">"+adres_mail
												+ "</adres_mail>"
										+"<telefon tel=\""+telefon+"\">"+telefon
										+ "</telefon></klient>";
		String login=request.getParameter("login");
		String haslo=request.getParameter("haslo");
		KlientDaoImpl kdi = new KlientDaoImpl();
		AdministratorDaoImpl adi = new AdministratorDaoImpl();
		PracownikDaoImpl pdi = new PracownikDaoImpl();
		
KlientModifyService kms=new KlientModifyService();
kd=kms.edycja(kd, dane, login, haslo);
request.getSession().setAttribute("KLIENT", kd);
response.sendRedirect("clientDane.jsp");
		

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
