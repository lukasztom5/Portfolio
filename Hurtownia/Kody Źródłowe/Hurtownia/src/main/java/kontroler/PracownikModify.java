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
import server.PracownikModifyService;
@WebServlet(name = "PracownikModify", urlPatterns = { "/PracownikModify" })
public class PracownikModify extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Pracownik p=(Pracownik)request.getSession().getAttribute("PRACOWNIK");
		String id=request.getParameter("id");
		String dane="<pracownik><idpracownik id=\""+id+"\">"+id
				+"<kod kod=\""+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "	+	request.getParameter("login")+"\">"
				+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "	+	request.getParameter("login")
									+"</kod></idpracownik>"
+ "<kraj country=\""+request.getParameter("kraj")+"\">"+request.getParameter("kraj")
+ "<miasto city=\""+request.getParameter("miasto")+"\">"+request.getParameter("miasto")
+ "<adres adr=\""+request.getParameter("adres")+"\">"+request.getParameter("adres")
		+ "</adres></miasto></kraj>"
		+ "<nazwisko surname=\""+request.getParameter("nazwisko")+"\">"+request.getParameter("nazwisko")
		+ "<imie name=\""+request.getParameter("imie")+"\">"+request.getParameter("imie")
		+"</imie></nazwisko>"

+ "<adres_mail am=\""+request.getParameter("adres_mail")+"\">"+request.getParameter("adres_mail")
		+ "</adres_mail>"
		+ "<telefon tel=\""+request.getParameter("telefon")+"\">"+request.getParameter("telefon")
		+ "</telefon>"
		+ "<telefon_sluzbowy tels=\""+request.getParameter("telefon_sluzbowy")+"\">"+request.getParameter("telefon_sluzbowy")
		+ "</telefon_sluzbowy>"
		+ "<numer_konta nk=\""+request.getParameter("numer_konta")+"\">"+request.getParameter("numer_konta")
				+ "</numer_konta>"
		+ "<pensja zar=\""+request.getParameter("pensja")+"\">"+request.getParameter("pensja")
				+ "</pensja>"
				+ "<data_zatr dh=\""+request.getParameter("data_zatrudnienia")+"\">"+request.getParameter("data_zatrudnienia")
				+ "<data_zak df=\""+request.getParameter("data_zakonczenia")+"\">"+request.getParameter("data_zakonczenia")
				+"</data_zak></data_zatr>"
		+ "</pracownik>";
		String login=request.getParameter("login");
		String haslo=request.getParameter("haslo");
		KlientDaoImpl kdi = new KlientDaoImpl();
		AdministratorDaoImpl adi = new AdministratorDaoImpl();
		PracownikDaoImpl pdi = new PracownikDaoImpl();
		Klient k = kdi.findbylogin(login);
		Pracownik pa=pdi.findbylogin(login);
		Administrator a=adi.findbylogin(login);	
		
		if(a==null && pa==null && k==null)	{
		PracownikModifyService kms=new PracownikModifyService();
		p=kms.edycja(p, dane, login, haslo);
		request.getSession().setAttribute("PRACOWNIK", p);
		response.sendRedirect("pracownicy.jsp");	
		}
		else if(login.equals(a.getLOGIN()) || login.equals(k.getLOGIN()) || login.equals(pa.getLOGIN())){
			response.sendRedirect("bladmodyfikacjipracownika.jsp");	
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
