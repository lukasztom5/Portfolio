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

public class DodajRozliczZwol extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		AdministratorDaoImpl addi=new AdministratorDaoImpl();
		Administrator ad=addi.findById(Integer.parseInt(request.getParameter("admin")));
	PracownikDaoImpl pdi=new PracownikDaoImpl();
	Pracownik p=pdi.findById(Integer.parseInt(request.getParameter("idpracownik")));
		
		RozliczenieDaoImpl rdi= new RozliczenieDaoImpl();
		Integer idroz=rdi.NewIdRozliczenie();
		String roz="<rozliczenie><idrozliczenie id=\""+idroz+"\">"+idroz
				+ "</idrozliczenie>"
				+ "<nazwisko surname=\""+request.getParameter("nazwisko")+"\">"+request.getParameter("nazwisko")
								+ "<imie name=\""+request.getParameter("imie")+"\">"+request.getParameter("imie")
								+ "<pensja zar=\""+request.getParameter("pensja")+"\">"+request.getParameter("pensja")
								+"</pensja></imie></nazwisko>"
								
								+ "<data_zatr dh=\""+"brak"+"\">"+"brak"
								+"<rodzaj_zatr rz=\""+"brak"+"\">"+"brak"
								+"</rodzaj_zatr></data_zatr>"
								
								+ "<data_zwol df=\""+request.getParameter("data_zakonczenia")+"\">"+request.getParameter("data_zakonczenia")
								+"<szczegoly_zwol sz=\""+request.getParameter("rodzaj")+"\">"+request.getParameter("rodzaj")
								+"</szczegoly_zwol></data_zwol>"
								
								+ "<data_roz dr=\""+"brak"+"\">"+"brak"
								+ "<wyplata wyp=\""+"brak"+"\">"+"brak"
								+ "<premia pr=\""+"brak"+"\">"+"brak"
								+"<szczegoly_prem sp=\""+"brak"+"\">"+"brak"
								+ "</szczegoly_prem></premia>"
								
								+ "<kara k=\""+"brak"+"\">"+"brak"
								+"<szczegoly_kary sk=\""+"brak"+"\">"+"brak"
								+ "</szczegoly_kary></kara></wyplata></data_roz>"
								+"</rozliczenie>";
		
		
		
		Rozliczenie rozliczenie = new Rozliczenie(idroz,ad,p,roz);
		try{
			ZatrudnijPracownikaService zps=new ZatrudnijPracownikaService ();
			boolean w=zps.dodawanie(rozliczenie);
			if(w){
request.getSession().setAttribute("idrozliczenie", idroz.toString());
				response.sendRedirect("PracownikRozliczenieAdmin.jsp");
			}
			else {

				response.sendRedirect("bladrozliczaniazwolnienia.jsp");
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
