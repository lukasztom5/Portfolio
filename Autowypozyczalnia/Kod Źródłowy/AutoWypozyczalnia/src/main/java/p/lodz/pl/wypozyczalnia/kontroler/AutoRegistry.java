package p.lodz.pl.wypozyczalnia.kontroler;
import p.lodz.pl.encje.Auta;
import p.lodz.pl.serwer.AutoRegistryService;
import p.lodz.pl.dao.AutoDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "AutoRegistry", urlPatterns = { "/AutoRegistry" })
public class AutoRegistry extends HttpServlet {

	private static final long serialVersionUID = -1077492084470774144L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String marka=request.getParameter("marka");
		String model=request.getParameter("model");
		String segment=request.getParameter("segment");
		String paliwo=request.getParameter("paliwo");
		String skrzyniaBiegow=request.getParameter("skrzynia_biegow");
		String numerRejestracyjny=request.getParameter("numer_rejestracyjny");
		String numer_VIN=request.getParameter("numer_VIN");
		String numerNadwozia=request.getParameter("numer_nadwozia");
		String numerSilnika=request.getParameter("numer_silnika");
		String rocznik=request.getParameter("rocznik");
		String kolor=request.getParameter("kolor");
		String moc_silnika_KM=request.getParameter("moc_silnika_KM");
		String napedNaKola=request.getParameter("naped_na_kola");
		String liczbaMiejsc=request.getParameter("liczba_miejsc");
		String liczbaDrzwi=request.getParameter("liczba_drzwi");
		String pojemnoscBagaznikaWLitrach=request.getParameter("pojemnosc_bagaznika_w_litrach");
		String zuzyciePaliwaNa100Km=request.getParameter("zuzycie_paliwa_na_100_km");
		
		AutoDaoImpl adi= new AutoDaoImpl();
		Integer idauta = adi.NewIdAuto();

		Auta auto=new Auta(idauta,marka, model, segment, paliwo, skrzyniaBiegow,
				numerRejestracyjny, numer_VIN, numerNadwozia, numerSilnika, rocznik, kolor, moc_silnika_KM,
				napedNaKola, liczbaMiejsc, liczbaDrzwi, pojemnoscBagaznikaWLitrach, zuzyciePaliwaNa100Km);

		try {
			AutoRegistryService ars=new AutoRegistryService();
			boolean result = ars.Dodawanie(auto);
			if (result) {
				request.getSession().setAttribute("idauta",
						idauta.toString());
				response.sendRedirect("auta.jsp");
			} 
			else {

				response.sendRedirect("bladauto.jsp");
			}
		} finally {
			out.close();
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