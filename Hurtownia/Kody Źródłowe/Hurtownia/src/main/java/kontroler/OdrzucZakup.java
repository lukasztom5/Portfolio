package kontroler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.HistoriaAktualneUpdate;
import dao.*;
import encje.*;

public class OdrzucZakup extends HttpServlet{
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
		HistoriaDaoImpl hhh = new HistoriaDaoImpl();
		AktualneZamowienia az= adi.findById(ko.getIdkoszyk());
		HistoriaZamowienia hh = hhh.findById(az.getIDAKTUALNEZAMOWIENIE());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String potwierdzenie1="<historia><idhistoria idh=\""+hh.getIDHISTORIAZAMOWIENIA()+"\">"+hh.getIDHISTORIAZAMOWIENIA()
				+ "</idhistoria>"
				+ "<data_zamowienia dza=\""+df.format(date).toString()+"\">"+df.format(date).toString()
		+ "<platnosc szz=\""+"brak"+"\">"+"brak"
		+ "</platnosc>"
		+ "<zaplata z=\""+"brak"+"\">"+"brak"
		+ "</zaplata>"
		+ "<data_zakonczenia dzk=\""+df.format(date).toString()+"\">"+df.format(date).toString()
		+"<status st=\""+"Odrzucone zamówienie"+"\">"+"Odrzucone zamówienie"
		+ "</status></data_zakonczenia>"
		+ "<cena c=\""+cw.getCena()+"\">"+cw.getCena()
		+ "<ilosc il=\""+kdo.getLiczba()+"\">"+kdo.getLiczba()
		+"<suma su=\""+kdo.getCena()+"\">"+kdo.getCena()
		+ "</suma></ilosc></cena>"
		+ "</data_zamowienia>"
+ "</historia>";
		
		HistoriaZamowienia hz=hdi.findById(ko.getIdkoszyk());
		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		
		hz = hms.edycja(hz, potwierdzenie1);
		request.getSession().setAttribute("idhistoria_zamowienie",
				hz);
		kdi1.removeById(ko.getIdkoszyk());
		adi.removeById(ko.getIdkoszyk());
		
		
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

