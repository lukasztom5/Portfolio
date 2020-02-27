package kontroler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class KoszykSzczegoly extends HttpServlet{
	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		AktualneDaoImpl adi=new AktualneDaoImpl();	
		KoszykDaoImpl kdi1 = new KoszykDaoImpl();
		Koszyk ko = kdi1.findById(Integer.parseInt(request.getParameter("idzakup")));
		CzescDaoImpl cdi = new CzescDaoImpl();
		Czesc c = cdi.findById(ko.getIdczesc().getIDCZESC());
		CzescDaneDaoImpl cddi = new CzescDaneDaoImpl();
		CzescWidok cw = cddi.findByIdczesc(c.getIDCZESC());
		KoszykDaneDaoImpl kddi = new KoszykDaneDaoImpl();
		KoszykDane kdo = kddi.findByIdkosz(ko.getIdkoszyk());
		AktualneZamowienia az = adi.findById(ko.getIdkoszyk());
		HistoriaDaoImpl hhh = new HistoriaDaoImpl();
		HistoriaZamowienia hh = hhh.findById(az.getIDAKTUALNEZAMOWIENIE());
		AktualneWidokDaoImpl awd = new AktualneWidokDaoImpl();
		AktualneWidok aww = awd.findByIdakt(az.getIDAKTUALNEZAMOWIENIE());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String potwierdzenie1="<historia><idhistoria idh=\""+hh.getIDHISTORIAZAMOWIENIA()+"\">"+hh.getIDHISTORIAZAMOWIENIA()
										+ "</idhistoria>"
										+ "<data_zamowienia dza=\""+df.format(aww.getDataZamowienia()).toString()+"\">"+df.format(aww.getDataZamowienia()).toString()
								+ "<platnosc szz=\""+request.getParameter("rodzaj")+"\">"+request.getParameter("rodzaj")
								+ "</platnosc>"
								+ "<zaplata z=\""+request.getParameter("zaplata")+"\">"+request.getParameter("zaplata")
								+ "</zaplata>"
								+ "<data_zakonczenia dzk=\""+request.getParameter("data_dostarczenia")+"\">"+request.getParameter("data_dostarczenia")
								+"<status st=\""+"Zatwierdzone"+"\">"+"Zatwierdzone"
								+ "</status></data_zakonczenia>"
								+ "<cena c=\""+cw.getCena()+"\">"+cw.getCena()
								+ "<ilosc il=\""+kdo.getLiczba()+"\">"+kdo.getLiczba()
								+"<suma su=\""+kdo.getCena()+"\">"+kdo.getCena()
								+ "</suma></ilosc></cena>"
								+ "</data_zamowienia>"
				+ "</historia>";
		
		String potwierdzenie2="<aktualne><idaktualne idh=\""+az.getIDAKTUALNEZAMOWIENIE()+"\">"+az.getIDAKTUALNEZAMOWIENIE()
				+"<idkoszyk idkoszyk=\""+aww.getId1()+"\">"+aww.getId1()
				+ "</idkoszyk></idaktualne>"
				+ "<data_zamowienia dza=\""+df.format(aww.getDataZamowienia()).toString()+"\">"+df.format(aww.getDataZamowienia()).toString()
		+ "<data_zakonczenia dzk=\""+request.getParameter("data_dostarczenia")+"\">"+request.getParameter("data_dostarczenia")
		+"<status st=\""+"Zatwierdzone"+"\">"+"Zatwierdzone"
		+ "</status></data_zakonczenia>"
		+ "</data_zamowienia>"
+ "</aktualne>";	
		
		AktualneZamowienia az1=adi.findById(az.getIDAKTUALNEZAMOWIENIE());
		HistoriaZamowienia hz=hdi.findById(az.getIDAKTUALNEZAMOWIENIE());
		
		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		Koszyk k = kdi1.findById(ko.getIdkoszyk());
		
		hz = hms.edycja(hz, potwierdzenie1);
		az1 = hms.edycja(az1,potwierdzenie2);		
			request.getSession().setAttribute("idaktualne_zamowienie",
					az);
			request.getSession().setAttribute("idhistoria_zamowienie",
					hz);
			
			kdi1.removeById(k.getIdkoszyk());
			response.sendRedirect("koszykklienta.jsp");
			
			
		
	
		
		
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
