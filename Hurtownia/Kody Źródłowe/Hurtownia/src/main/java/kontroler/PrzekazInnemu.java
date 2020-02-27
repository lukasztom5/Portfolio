package kontroler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

@WebServlet(name = "PrzekazInnemu", urlPatterns = { "/PrzekazInnemu" })
public class PrzekazInnemu extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		AktualneDaoImpl adi= new AktualneDaoImpl();
		AktualneZamowienia az=adi.findById(Integer.parseInt(request.getParameter("idaktualne_zamowienie")));
		
		AktualneWidokDaoImpl awdi = new AktualneWidokDaoImpl();
		AktualneWidok aw=awdi.findByIdakt(az.getIDAKTUALNEZAMOWIENIE());
		
		HistoriaDaoImpl hdi= new HistoriaDaoImpl();
		HistoriaZamowienia h=hdi.findById(az.getIDAKTUALNEZAMOWIENIE());
		
		KlientDaoImpl kdi = new KlientDaoImpl();
		Klient k=kdi.findById(az.getIDKLIENT().getIDKLIENT());
		
		HistoriaWidokDaoImpl hwdi= new HistoriaWidokDaoImpl();
		HistoriaWidok hw= hwdi.findByIdhist(h.getIDHISTORIAZAMOWIENIA());
		
		PracownikDaoImpl pdi=new PracownikDaoImpl();
		
		List<Pracownik> lista1 = pdi.findbykod(request.getParameter("idprac1"));
		System.out.println(request.getParameter("idprac1"));
		System.out.println(request.getParameter("idprac2"));
		List<Pracownik> lista2 = pdi.findbykod(request.getParameter("idprac2"));
		
		CzescDaoImpl cdi = new CzescDaoImpl();
		Czesc c=cdi.findById(az.getIDCZESC().getIDCZESC());
	for(Pracownik pp1: lista1)	{
		
		for(Pracownik pp2: lista2){
	
		PracDaneDaoImpl pddi= new PracDaneDaoImpl();
		PracDane pr=pddi.findByIdprac(pp2.getIDPRACOWNIK());
		PracDane ps=pddi.findByIdprac(pp1.getIDPRACOWNIK());

		Integer idakt=adi.NewIdAktualne();
		Integer idhis=hdi.NewIdHistoria();
		
		String Dane="<aktualne><idaktualne idh=\""+idakt+"\">"+idakt
				+"</idkoszyk idkoszyk=\""+aw.getId1()+"\">"+aw.getId1()
				+ "</idkoszyk></idaktualne>"
		+ "<data_zamowienia dza=\""+aw.getDataZamowienia()+"\">"+aw.getDataZamowienia()
+ "<data_zakonczenia dzk=\""+aw.getDataZakonczenia()+"\">"+aw.getDataZakonczenia()
+"<status st=\""+"Otrzymane Od "+ps.getImie()+" "+ps.getNazwisko()+"\">"+"Otrzymane Od "+ps.getImie()+" "+ps.getNazwisko()
+ "</status></data_zakonczenia>"
+ "</data_zamowienia>"
+ "</aktualne>";
		
		String potwierdzenie1="<historia><idhistoria idh=\""+h.getIDHISTORIAZAMOWIENIA()+"\">"+h.getIDHISTORIAZAMOWIENIA()
		+ "</idhistoria>"
		+ "<data_zamowienia dza=\""+hw.getDataZamowienia()+"\">"+hw.getDataZamowienia()
+ "<platnosc szz=\""+hw.getPlatnosc()+"\">"+hw.getPlatnosc()
+ "</platnosc>"
+ "<zaplata z=\""+hw.getZaplata()+"\">"+hw.getZaplata()
+ "</zaplata>"
+ "<data_zakonczenia dzk=\""+hw.getDataZakonczenia()+"\">"+hw.getDataZakonczenia()
+"<status st=\""+""+"Przekazane "+pr.getImie()+" "+pr.getNazwisko()+"\">"+"Przekazane "+pr.getImie()+" "+pr.getNazwisko()
+ "</status></data_zakonczenia>"
+ "<cena c=\""+hw.getCena()+"\">"+hw.getCena()
+ "<ilosc il=\""+hw.getIlosc()+"\">"+hw.getIlosc()
+"<suma su=\""+hw.getSuma()+"\">"+hw.getSuma()
+ "</suma></ilosc></cena>"
+ "</data_zamowienia>"
+ "</historia>";

		
		String potwierdzenie2="<historia><idhistoria idh=\""+idhis+"\">"+idhis
		+ "</idhistoria>"
		+ "<data_zamowienia dza=\""+hw.getDataZamowienia()+"\">"+hw.getDataZamowienia()
+ "<platnosc szz=\""+hw.getPlatnosc()+"\">"+hw.getPlatnosc()
+ "</platnosc>"
+ "<zaplata z=\""+hw.getZaplata()+"\">"+hw.getZaplata()
+ "</zaplata>"
+ "<data_zakonczenia dzk=\""+hw.getDataZakonczenia()+"\">"+hw.getDataZakonczenia()
+"<status st=\""+""+"Otrzymane Od "+ps.getImie()+" "+ps.getNazwisko()+"\">"+"Otrzymane Od "+ps.getImie()+" "+ps.getNazwisko()
+ "</status></data_zakonczenia>"
+ "<cena c=\""+hw.getCena()+"\">"+hw.getCena()
+ "<ilosc il=\""+hw.getIlosc()+"\">"+hw.getIlosc()
+"<suma su=\""+hw.getSuma()+"\">"+hw.getSuma()
+ "</suma></ilosc></cena>"
+ "</data_zamowienia>"
+ "</historia>";
		
		AktualneZamowienia az1=new AktualneZamowienia(idakt,k,pp2,c,Dane);
		HistoriaZamowienia hz=new HistoriaZamowienia(idhis,k,pp2,c,potwierdzenie2);
		HistoriaAktualneUpdate hms= new HistoriaAktualneUpdate();
		h=hms.edycja(h, potwierdzenie1);
		adi.removeById(az.getIDAKTUALNEZAMOWIENIE());
		
		try {
			DodajZamowienieService aws=new DodajZamowienieService();
			boolean result = aws.dodaj1(az1);
			boolean result2 = aws.dodaj2(hz);
			if (result && result2) {
				request.getSession().setAttribute("idaktualne_zamowienie",
						idakt.toString());
				request.getSession().setAttribute("idhistoria_zamowienie",
						idhis.toString());
				
				response.sendRedirect("PracownikAktualneZamowieniaAdmin.jsp");
			}
			else {

				response.sendRedirect("bladzmiany.jsp");
			}
		
		} finally {
			pw.close();
		}
		}}
	
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
