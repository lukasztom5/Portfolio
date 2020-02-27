package kontroler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class DodajDoKoszyka extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		Klient kd=(Klient)request.getSession().getAttribute("klient");
		CzescDaoImpl cdi = new CzescDaoImpl();
		Czesc c= cdi.findById(Integer.parseInt(request.getParameter("idczesc")));
		CzescDaneDaoImpl cddi = new CzescDaneDaoImpl();
		CzescWidok cw= cddi.findByIdczesc(c.getIDCZESC());
		AktualneDaoImpl adi = new AktualneDaoImpl();
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		KoszykDaoImpl kdi = new KoszykDaoImpl();
		Integer idhis=hdi.NewIdHistoria();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		List<AktualneZamowienia> az= adi.findAll();
		
		String dane1="<czesc><idczesc id=\""+c.getIDCZESC()+"\">"+c.getIDCZESC()
				+ "</idczesc><obraz obraz=\""+cw.getObraz()+"\">"+cw.getObraz()+"</obraz>"
				+ "<nazwa n=\""+cw.getNazwa()+"\">"+cw.getNazwa()
+ "<cena c=\""+cw.getCena()+"\">"+cw.getCena()
+ "</cena><sztuki sz=\""+(cw.getIlosc()-Integer.parseInt(request.getParameter("sztuki")))+"\">"+(cw.getIlosc()-Integer.parseInt(request.getParameter("sztuki")))
+ "</sztuki></nazwa></czesc>";
		
	
		
		String dane="<koszyk><id id=\""+idhis+"\">"+idhis
										+ "</id>"
				+"<idklient idklient=\""+kd.getIDKLIENT()+"\">"+kd.getIDKLIENT()+"</idklient>"
				+ "<produkt produkt=\""+cw.getNazwa()+"\">"+cw.getNazwa()
				+"<liczba liczba=\""+(cw.getIlosc()-cw.getIlosc()+Integer.parseInt(request.getParameter("sztuki")))+"\">"+(cw.getIlosc()-cw.getIlosc()+Integer.parseInt(request.getParameter("sztuki")))
				+"<suma suma=\""+(cw.getCena()*Integer.parseInt(request.getParameter("sztuki")))+"\">"+(cw.getCena()*Integer.parseInt(request.getParameter("sztuki")))
				+"</suma></liczba></produkt></koszyk>";
		
		
		
		String potwierdzenie2="<aktualne><idaktualne idh=\""+idhis+"\">"+idhis
				+"<idkoszyk idkoszyk=\""+idhis+"\">"+idhis
				+ "</idkoszyk></idaktualne>"
				+ "<data_zamowienia dza=\""+df.format(dateobj).toString()+"\">"+df.format(dateobj).toString()
		+ "<data_zakonczenia dzk=\""+df.format(dateobj).toString()+"\">"+df.format(dateobj).toString()
		+"<status st=\""+"Weryfikacja zamówienia"+"\">"+"Weryfikacja zamówienia"
		+ "</status></data_zakonczenia>"
		+ "</data_zamowienia>"
+ "</aktualne>";
		String potwierdzenie1="<historia><idhistoria idh=\""+idhis+"\">"+idhis
				+ "</idhistoria>"
				+ "<data_zamowienia dza=\""+df.format(dateobj).toString()+"\">"+df.format(dateobj).toString()
		+ "<platnosc szz=\""+"Brak"+"\">"+"Brak"
		+ "</platnosc>"
		+ "<zaplata z=\""+"Brak"+"\">"+"Brak"
		+ "</zaplata>"
		+ "<data_zakonczenia dzk=\""+df.format(dateobj).toString()+"\">"+df.format(dateobj).toString()
		+"<status st=\""+"Weryfikacja zamówienia"+"\">"+"Weryfikacja zamówienia"
		+ "</status></data_zakonczenia>"
		+ "<cena c=\""+cw.getCena()+"\">"+cw.getCena()
		+ "<ilosc il=\""+Integer.parseInt(request.getParameter("sztuki"))+"\">"+Integer.parseInt(request.getParameter("sztuki"))
		+"<suma su=\""+(cw.getCena()*Integer.parseInt(request.getParameter("sztuki")))+"\">"+(cw.getCena()*Integer.parseInt(request.getParameter("sztuki")))
		+ "</suma></ilosc></cena>"
		+ "</data_zamowienia>"
+ "</historia>";	
		
		PracownikDaoImpl pdi = new PracownikDaoImpl();
		List <Pracownik> p = pdi.findtop1();
		List <Koszyk> ko = kdi.findByIdkl(kd.getIDKLIENT());
		List <Pracownik> ytr= pdi.findtop1a();
		EditCzescMService kms=new EditCzescMService();
		

		
		
		Koszyk model= new Koszyk(idhis,kd,c,dane);
		
		
		
		try{
			ZakupDodaj zd = new ZakupDodaj();
			
			boolean r=zd.dodaj(model);
			
			
			if(r){
				c=kms.edycja(c, dane1);
				if(ko.size()==0){
					if(az.size()==0){
						for(Pracownik l:p){
							HistoriaZamowienia historia = new HistoriaZamowienia(idhis, kd, l, c, potwierdzenie1);
							AktualneZamowienia aktualne = new AktualneZamowienia(idhis,kd,l,c,potwierdzenie2);
							
							DodajZamowienieService add = new DodajZamowienieService();
							add.dodaj1(aktualne);
							add.dodaj2(historia);
						}
					}
					else if(az.size()>0){
						
						if(p.size()>0){
						for(Pracownik l:p){
							HistoriaZamowienia historia = new HistoriaZamowienia(idhis, kd, l, c, potwierdzenie1);
							AktualneZamowienia aktualne = new AktualneZamowienia(idhis,kd,l,c,potwierdzenie2);
							DodajZamowienieService add = new DodajZamowienieService();
							add.dodaj1(aktualne);
							add.dodaj2(historia);
						}
					}
						else if(p.size()==0){
							
							for(Pracownik lw :ytr){
								HistoriaZamowienia historia = new HistoriaZamowienia(idhis, kd, lw, c, potwierdzenie1);
								AktualneZamowienia aktualne = new AktualneZamowienia(idhis,kd,lw,c,potwierdzenie2);
								DodajZamowienieService add = new DodajZamowienieService();
								add.dodaj1(aktualne);
								add.dodaj2(historia);
							}
							
						}
						
						
				}
				}
				else if(ko.size()>0){
					for (Koszyk u: ko){
						List<AktualneZamowienia> po = adi.findBykcd(u.getIdklient().getIDKLIENT(), u.getIdczesc().getIDCZESC());
						for(AktualneZamowienia pol: po){
						Pracownik w = pdi.findById(pol.getIDPRACOWNIK().getIDPRACOWNIK());
						HistoriaZamowienia historia = new HistoriaZamowienia(idhis, kd, w, c, potwierdzenie1);
						AktualneZamowienia aktualne = new AktualneZamowienia(idhis,kd,w,c,potwierdzenie2);
						DodajZamowienieService add = new DodajZamowienieService();
						add.dodaj1(aktualne);
						add.dodaj2(historia);
						}
					}
				}
				response.sendRedirect("zamowienie.jsp");
			}
			else {

				response.sendRedirect("bladzamowienia.jsp");
			}
		
		}finally{
			pw.close();
		
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
