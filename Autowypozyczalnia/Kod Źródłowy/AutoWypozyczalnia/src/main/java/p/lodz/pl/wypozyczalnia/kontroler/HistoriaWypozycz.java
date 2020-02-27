package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.serwer.HistoriaWypozyczService;
import p.lodz.pl.dao.HistoriaDaoImpl;
import p.lodz.pl.dao.SegmentDaoImpl;
import p.lodz.pl.dao.WyposazenieDaoImpl;
import p.lodz.pl.encje.HistoriaWypozyczenia;
import p.lodz.pl.encje.Wyposazenie;

@WebServlet(name="HistoriaWypozycz", urlPatterns={"/HistoriaWypozycz"})
public class HistoriaWypozycz extends HttpServlet{

	private static final long serialVersionUID = -2864487370618713224L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		int idauta=Integer.parseInt(request.getParameter("idauta"));
		int idklient=Integer.parseInt(request.getParameter("idklient"));
		String marka=request.getParameter("marka");
		String model=request.getParameter("model");
		String imie=request.getParameter("imie");
		String nazwisko=request.getParameter("nazwisko");
		String terminWypozyczenia=request.getParameter("termin_wypozyczenia");
		String terminOddania=request.getParameter("termin_oddania");
		String dodatek1=request.getParameter("dodatek1");
		String dodatek2=request.getParameter("dodatek2");
		String dodatek3=request.getParameter("dodatek3");
		String dodatek4=request.getParameter("dodatek4");
		String dodatek5=request.getParameter("dodatek5");
		String dodatek6=request.getParameter("dodatek6");
		String[] listadodatki={dodatek1,dodatek2,dodatek3,dodatek4,dodatek5,dodatek6};
		String ld=request.getParameter("liczba_dni");
		String segment=request.getParameter("segment");
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
		HistoriaWypozyczenia hw=new HistoriaWypozyczenia(idhistoria_wypozyczenia,idklient,idauta,marka,model,imie,nazwisko,
				terminWypozyczenia,terminOddania,LiczbaDni,CenaSegment,CenaDodatek,wyposazenie,Cena,status);
		try {
			HistoriaWypozyczService hws=new HistoriaWypozyczService();
			boolean result = hws.rejestracja(hw);
			if (result) {
				request.getSession().setAttribute("idhistoria_wypozyczenia",
						idhistoria_wypozyczenia.toString());
				response.sendRedirect("klientHistoriaWypozyczen.jsp");
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
