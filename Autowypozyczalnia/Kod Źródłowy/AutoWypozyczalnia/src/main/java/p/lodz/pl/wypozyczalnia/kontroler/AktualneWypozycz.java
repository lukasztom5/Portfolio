package p.lodz.pl.wypozyczalnia.kontroler;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.serwer.AktualneWypozyczService;
import p.lodz.pl.dao.AktualneDaoImpl;
import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.dao.SegmentDaoImpl;
import p.lodz.pl.dao.WyposazenieDaoImpl;
import p.lodz.pl.encje.AktualneWypozyczenie;
import p.lodz.pl.encje.HistoriaWypozyczenia;
import p.lodz.pl.encje.Wyposazenie;
@WebServlet(name="AktualneWypozycz", urlPatterns={"/AktualneWypozycz"})
public class AktualneWypozycz extends HttpServlet{

	private static final long serialVersionUID = 71895060638121134L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int idauta=Integer.parseInt(request.getParameter("idauta"));
		int idklient=Integer.parseInt(request.getParameter("idklient"));
		String marka=request.getParameter("marka");
		String model=request.getParameter("model");
		String imie=request.getParameter("imie");
		String nazwisko=request.getParameter("nazwisko");
		String dataRezerwacja=request.getParameter("data_rezerwacja");
		String dataZwrotu=request.getParameter("data_zwrotu");
		
		String dodatek1=request.getParameter("dodatek1");
		String dodatek2=request.getParameter("dodatek2");
		String dodatek3=request.getParameter("dodatek3");
		String dodatek4=request.getParameter("dodatek4");
		String dodatek5=request.getParameter("dodatek5");
		String dodatek6=request.getParameter("dodatek6");
		String[] listadodatki={dodatek1,dodatek2,dodatek3,dodatek4,dodatek5,dodatek6};
		String ld=request.getParameter("liczba_dni");
		String segment=request.getParameter("segment");
		int Kilometry=new Integer(0);
		String uwagi=new String("brak danych");
		Double dodatkowyKoszt=new Double(0);
		Double CenaDodatek=new Double(0);
		String wyposazenie=new String("");
		int LiczbaDni=Integer.parseInt(ld);
		WyposazenieDaoImpl wdi=new WyposazenieDaoImpl();
		String status="brak";
		
		for (int i = 0; i < listadodatki.length; i++) {

			if (listadodatki[i].startsWith("add")) {
				Wyposazenie w = wdi.findById(Integer
						.parseInt(listadodatki[i].substring(3,
								listadodatki[i].length())));
				CenaDodatek = CenaDodatek+w.getCenaDzien();
				wyposazenie=wyposazenie+w.getDodatek()+", ";
			}
		}
		
		SegmentDaoImpl sdi=new SegmentDaoImpl();
		int CenaSegment=sdi.findSegment(segment).getCenaZaDobe();
		
		double Cena= LiczbaDni*(CenaDodatek+CenaSegment);
		HistoriaDaoImpl hdi=new HistoriaDaoImpl();
		Integer idhistoria_wypozyczenia=hdi.NewIdHistoria();
		
		AktualneDaoImpl adi=new AktualneDaoImpl();
		Integer idaktualne_wypozyczenie=adi.NewIdAktualne();
		
		
		AktualneWypozyczenie aw=new AktualneWypozyczenie(idaktualne_wypozyczenie,idklient,idauta, marka, model, imie, 
				nazwisko, formatter.parse(dataRezerwacja),formatter.parse(dataZwrotu));
		HistoriaWypozyczenia hw=new HistoriaWypozyczenia(idhistoria_wypozyczenia,idklient,idauta,marka,model,imie,nazwisko,
				formatter.parse(dataRezerwacja),formatter.parse(dataZwrotu),LiczbaDni,CenaSegment,CenaDodatek,wyposazenie,Cena,status,
				Kilometry,uwagi,dodatkowyKoszt);
		
		
		try {
			AktualneWypozyczService aws=new AktualneWypozyczService();
			boolean result = aws.rejestracja(aw);
			boolean result2 = aws.rejestracja(hw);
			if (result || result2) {
				request.getSession().setAttribute("idaktualne_wypozyczenie",
						idaktualne_wypozyczenie.toString());
				request.getSession().setAttribute("idhistoria_wypozyczenia",
						idaktualne_wypozyczenie.toString());
				response.sendRedirect("wypozyczenie_cz2.jsp");
			}
			else {

				response.sendRedirect("bladwypozyczenie.jsp");
			}
		
		} finally {
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
