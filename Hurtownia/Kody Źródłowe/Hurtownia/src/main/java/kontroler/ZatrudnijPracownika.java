package kontroler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class ZatrudnijPracownika extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		PracownikDaoImpl pdi=new PracownikDaoImpl();
		Integer idprac=pdi.NewIdPracownik();
		AdministratorDaoImpl addi=new AdministratorDaoImpl();
		Administrator ad=addi.findById(Integer.parseInt(request.getParameter("admin")));
		String dane="<pracownik><idpracownik id=\""+idprac+"\">"+idprac
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
		
		
		Pracownik pracownik= new Pracownik(idprac, ad,dane, login, haslo);
		try{
			ZatrudnijPracownikaService zps=new ZatrudnijPracownikaService ();
			boolean r=zps.zatrudnienie(pracownik);
			if(r){
				request.getSession().setAttribute("idpracownik", idprac.toString());
				response.sendRedirect("pracownicy.jsp");
			}
			else {

				response.sendRedirect("bladzatrudnienia.jsp");
			}
		
		}finally{
			pw.close();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
