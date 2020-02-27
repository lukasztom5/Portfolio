package kontroler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class Zamow extends HttpServlet{
	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		AktualneDaoImpl adi=new AktualneDaoImpl();
		Integer idakt=adi.NewIdAktualne();
		Integer idhis=hdi.NewIdHistoria();
		KlientDaoImpl kdi= new KlientDaoImpl();
		Klient k=kdi.findById(Integer.parseInt(request.getParameter("idklient")));
		PracownikDaoImpl pdi= new PracownikDaoImpl();
		Pracownik p=pdi.findById(Integer.parseInt(request.getParameter("idpracownik")));
		CzescDaoImpl cdi= new CzescDaoImpl();
		Czesc c=cdi.findById(Integer.parseInt(request.getParameter("idczesc")));
		float cena=Float.parseFloat(request.getParameter("cena"));
		int ilosc=Integer.parseInt(request.getParameter("sztuki"));
		float suma=cena*ilosc;
		String su=Float.toString(suma);
		
		
		String potwierdzenie1="<historia><idhistoria idh=\""+idhis+"\">"+idhis
										+ "</idhistoria>"
										+ "<data_zamowienia dza=\""+request.getParameter("data_zamowienia")+"\">"+request.getParameter("data_zamowienia")
								+ "<platnosc szz=\""+request.getParameter("rodzaj")+"\">"+request.getParameter("rodzaj")
								+ "</platnosc>"
								+ "<zaplata z=\""+request.getParameter("zaplata")+"\">"+request.getParameter("zaplata")
								+ "</zaplata>"
								+ "<data_zakonczenia dzk=\""+request.getParameter("data_dostarczenia")+"\">"+request.getParameter("data_dostarczenia")
								+"<status st=\""+"Zatwierdzone"+"\">"+"Zatwierdzone"
								+ "</status></data_zakonczenia>"
								+ "<cena c=\""+request.getParameter("cena")+"\">"+request.getParameter("cena")
								+ "<ilosc il=\""+request.getParameter("sztuki")+"\">"+request.getParameter("sztuki")
								+"<suma su=\""+su+"\">"+su
								+ "</suma></ilosc></cena>"
								+ "</data_zamowienia>"
				+ "</historia>";
		
		String potwierdzenie2="<aktualne><idaktualne idh=\""+idakt+"\">"+idakt
				+"<idkoszyk idkoszyk=\""+0+"\">"+0
				+ "</idkoszyk></idaktualne>"
				+ "<data_zamowienia dza=\""+request.getParameter("data_zamowienia")+"\">"+request.getParameter("data_zamowienia")
		+ "<data_zakonczenia dzk=\""+request.getParameter("data_dostarczenia")+"\">"+request.getParameter("data_dostarczenia")
		+"<status st=\""+"Zatwierdzone"+"\">"+"Zatwierdzone"
		+ "</status></data_zakonczenia>"
		+ "</data_zamowienia>"
+ "</aktualne>";

		CzescDaneDaoImpl udi1 =new CzescDaneDaoImpl();
		CzescWidok ud=udi1.findByIdczesc(c.getIDCZESC());		
		int u=ud.getIlosc()-Integer.parseInt(request.getParameter("sztuki"));
		String u1=Integer.toString(u);
		String dane="<czesc><idczesc id=\""+c.getIDCZESC()+"\">"+c.getIDCZESC()
				+ "</idczesc>"
				+ "<nazwa n=\""+ud.getNazwa()+"\">"+ud.getNazwa()
+ "<cena c=\""+request.getParameter("cena")+"\">"+request.getParameter("cena")
+ "</cena><sztuki sz=\""+u1+"\">"+u1
+ "</sztuki></nazwa></czesc>";		
		
EditCzescMService kms=new EditCzescMService();
c=kms.edycja(c, dane);		
		
	AktualneZamowienia az=new AktualneZamowienia(idakt,k,p,c,potwierdzenie2);
	HistoriaZamowienia hz=new HistoriaZamowienia(idhis,k,p,c,potwierdzenie1);
	
	try {
		DodajZamowienieService aws=new DodajZamowienieService();
		boolean result = aws.dodaj1(az);
		boolean result2 = aws.dodaj2(hz);
		if (result) {
			request.getSession().setAttribute("idaktualne_zamowienie",
					idakt.toString());
			if (result2) {
			request.getSession().setAttribute("idhistoria_zamowienie",
					idhis.toString());
			request.getSession().setAttribute("idczesc", c);
			}
			response.sendRedirect("zamowieniaKlient.jsp");
		}
		else {

			response.sendRedirect("bladrezerwacja.jsp");
		}
	} finally {
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
