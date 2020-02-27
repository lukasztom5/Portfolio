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
@WebServlet(name = "AnulujAktualne", urlPatterns = { "/AnulujAktualne" })
public class AnulujAktualne extends HttpServlet{
	
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
		Czesc c=cdi.findById(Integer.parseInt(request.getParameter("idczesc")));
		
		CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
		CzescWidok kd4=kdi2.findByIdczesc(c.getIDCZESC());	
	
		int suma =kd4.getIlosc()+hw.getIlosc();
		String su = Integer.toString(suma);
		
		String potwierdzenie1="<historia><idhistoria idh=\""+h.getIDHISTORIAZAMOWIENIA()+"\">"+h.getIDHISTORIAZAMOWIENIA()
				+ "</idhistoria>"
				+ "<data_zamowienia dza=\""+hw.getDataZamowienia()+"\">"+hw.getDataZamowienia()
		+ "<platnosc szz=\""+hw.getPlatnosc()+"\">"+hw.getPlatnosc()
		+ "</platnosc>"
		+ "<zaplata z=\""+hw.getZaplata()+"\">"+hw.getZaplata()
		+ "</zaplata>"
		+ "<data_zakonczenia dzk=\""+hw.getDataZakonczenia()+"\">"+hw.getDataZakonczenia()
		+"<status st=\""+request.getParameter("status")+"\">"+request.getParameter("status")
		+ "</status></data_zakonczenia>"
		+ "<cena c=\""+kd4.getCena()+"\">"+kd4.getCena()
		+ "<ilosc il=\""+hw.getIlosc()+"\">"+hw.getIlosc()
		+"<suma su=\""+hw.getSuma()+"\">"+hw.getSuma()
		+ "</suma></ilosc></cena>"
		+ "</data_zamowienia>"
+ "</historia>";
	
		
		String dane="<czesc><idczesc id=\""+c.getIDCZESC()+"\">"+c.getIDCZESC()
		+ "</idczesc><obraz obraz=\""+kd4.getObraz()+"\">"+kd4.getObraz()+"</obraz>"
		+ "<nazwa n=\""+kd4.getNazwa()+"\">"+kd4.getNazwa()
+ "<cena c=\""+kd4.getCena()+"\">"+kd4.getCena()
+ "</cena><sztuki sz=\""+su+"\">"+su
+ "</sztuki></nazwa></czesc>";	


		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		EditCzescMService kms=new EditCzescMService();
		c=kms.edycja(c, dane);
		h=hms.edycja(h, potwierdzenie1);
		KoszykDaoImpl kdi = new KoszykDaoImpl();
		kdi.removeById(az.getIDKLIENT().getIDKLIENT());
		adi.removeById(az.getIDAKTUALNEZAMOWIENIE());
		request.getSession().setAttribute("idhistoria_zamowienie", h);
		request.getSession().setAttribute("idczesc", c);
		
		
		
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
