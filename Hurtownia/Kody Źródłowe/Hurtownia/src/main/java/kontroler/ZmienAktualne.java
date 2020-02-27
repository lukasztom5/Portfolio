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
@WebServlet(name = "ZmienAktualne", urlPatterns = { "/ZmienAktualne" })
public class ZmienAktualne extends HttpServlet{
	
	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		AktualneDaoImpl adi= new AktualneDaoImpl();
		AktualneZamowienia az=adi.findById(Integer.parseInt(request.getParameter("idaktualne_zamowienie")));
		AktualneWidokDaoImpl awdi = new AktualneWidokDaoImpl();
		AktualneWidok aw = awdi.findByIdakt(az.getIDAKTUALNEZAMOWIENIE());
		
		HistoriaDaoImpl hdi= new HistoriaDaoImpl();
		HistoriaZamowienia h=hdi.findById(az.getIDAKTUALNEZAMOWIENIE());
		
		CzescDaoImpl cdi= new CzescDaoImpl();
		Czesc c=cdi.findById(Integer.parseInt(request.getParameter("idczesc")));
		
		CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
		CzescWidok kd4=kdi2.findByIdczesc(c.getIDCZESC());
		
		int suma= Integer.parseInt(request.getParameter("dostep"))+Integer.parseInt(request.getParameter("stara"))-Integer.parseInt(request.getParameter("nowa"));
		String ilosc=Integer.toString(suma);
		
		double zap=Integer.parseInt(request.getParameter("nowa"))*kd4.getCena();
		String zap1=Double.toString(zap);
		
		
		String dane="<czesc><idczesc id=\""+kd4.getId()+"\">"+kd4.getId()
				+ "</idczesc>"
				+ "<nazwa n=\""+kd4.getNazwa()+"\">"+kd4.getNazwa()
+ "<cena c=\""+kd4.getCena()+"\">"+kd4.getCena()
+ "</cena><sztuki sz=\""+ilosc+"\">"+ilosc
+ "</sztuki></nazwa></czesc>";
		
		String potwierdzenie2="<aktualne><idaktualne idh=\""+az.getIDAKTUALNEZAMOWIENIE()+"\">"+az.getIDAKTUALNEZAMOWIENIE()
				+"<idkoszyk idkoszyk=\""+aw.getId1()+"\">"+aw.getId1()
				+ "</idkoszyk></idaktualne>"
				+ "<data_zamowienia dza=\""+request.getParameter("data_zamowienia")+"\">"+request.getParameter("data_zamowienia")
		+ "<data_zakonczenia dzk=\""+request.getParameter("data_zakonczenia")+"\">"+request.getParameter("data_zakonczenia")
		+"<status st=\""+request.getParameter("status")+"\">"+request.getParameter("status")
		+ "</status></data_zakonczenia>"
		+ "</data_zamowienia>"
+ "</aktualne>";
	
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
		+ "<ilosc il=\""+request.getParameter("nowa")+"\">"+request.getParameter("nowa")
		+"<suma su=\""+zap1+"\">"+zap1
		+ "</suma></ilosc></cena>"
		+ "</data_zamowienia>"
+ "</historia>";
		
		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		EditCzescMService kms=new EditCzescMService();
		c=kms.edycja(c, dane);
		az=hms.edycja(az, potwierdzenie2);
		h=hms.edycja(h, potwierdzenie1);
		request.getSession().setAttribute("idaktualne_zamowienie", az);
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
