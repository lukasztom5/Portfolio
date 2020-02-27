package kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.*;
import server.*;
import dao.*;
@WebServlet(name = "UsunAktualne", urlPatterns = { "/UsunAktualne" })
public class UsunAktualne extends HttpServlet{
	
	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		AktualneDaoImpl adi= new AktualneDaoImpl();
		AktualneZamowienia az=adi.findById(Integer.parseInt(request.getParameter("idaktualne_zamowienie")));
		
		
		HistoriaDaoImpl hdi= new HistoriaDaoImpl();
		HistoriaZamowienia h=hdi.findById(Integer.parseInt(request.getParameter("idhistoria_zamowienie")));
		
		HistoriaWidokDaoImpl hwdi = new HistoriaWidokDaoImpl();
		HistoriaWidok hw = hwdi.findByIdhist(h.getIDHISTORIAZAMOWIENIA());
		
		CzescDaoImpl cdi= new CzescDaoImpl();
		Czesc c=cdi.findById(h.getIDCZESC().getIDCZESC());
		
		CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
		CzescWidok kd4=kdi2.findByIdczesc(c.getIDCZESC());	
	
		String potwierdzenie1="<historia><idhistoria idh=\""+h.getIDHISTORIAZAMOWIENIA()+"\">"+h.getIDHISTORIAZAMOWIENIA()
				+ "</idhistoria>"
				+ "<data_zamowienia dza=\""+request.getParameter("data_zamowienia")+"\">"+request.getParameter("data_zamowienia")
		+ "<platnosc szz=\""+request.getParameter("rodzaj")+"\">"+request.getParameter("rodzaj")
		+ "</platnosc>"
		+ "<zaplata z=\""+request.getParameter("zaplata")+"\">"+request.getParameter("zaplata")
		+ "</zaplata>"
		+ "<data_zakonczenia dzk=\""+request.getParameter("data_zakonczenia")+"\">"+request.getParameter("data_zakonczenia")
		+"<status st=\""+request.getParameter("status")+"\">"+request.getParameter("status")
		+ "</status></data_zakonczenia>"
		+ "<cena c=\""+kd4.getCena()+"\">"+kd4.getCena()
		+ "<ilosc il=\""+hw.getIlosc()+"\">"+hw.getIlosc()
		+"<suma su=\""+hw.getSuma()+"\">"+hw.getSuma()
		+ "</suma></ilosc></cena>"
		+ "</data_zamowienia>"
+ "</historia>";
		
		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		h=hms.edycja(h, potwierdzenie1);
		adi.removeById(az.getIDAKTUALNEZAMOWIENIE());
		request.getSession().setAttribute("idhistoria_zamowienie", h);
		
		response.sendRedirect("praca.jsp");	
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
