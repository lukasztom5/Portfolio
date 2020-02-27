package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.encje.HistoriaWypozyczenia ;
import p.lodz.pl.serwer.HistoriaEditService;

@WebServlet(name = "HistoriaEdit", urlPatterns = { "/HistoriaEdit" })
public class HistoriaEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
response.setContentType("text/html;charset=UTF-8");
		
		HistoriaWypozyczenia hw=(HistoriaWypozyczenia)request.getSession().getAttribute(
				"historia_wypozyczenia");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String terminOddania=request.getParameter("terminOddania");
		String status=request.getParameter("zaliczka");
		String dni=request.getParameter("liczbaDni");
		String dodatkowyKoszt=request.getParameter("dodatkowyKoszt");
		String kilometry=request.getParameter("kilometry");
		String uwagi=request.getParameter("uwagi");
		
		int LiczbaDni=Integer.parseInt(dni);
		int Kilometr=Integer.parseInt(kilometry);
		double dk=Double.parseDouble(dodatkowyKoszt);
		
		double CenaCalosc=LiczbaDni*(hw.getCenaSegment()+hw.getCenaDodatek())+dk;
		
		HistoriaEditService hes=new HistoriaEditService ();
		hw=hes.edycja(hw,  formatter.parse(terminOddania), LiczbaDni,CenaCalosc,status,Kilometr,uwagi,dk);
		request.getSession().setAttribute("historia_wypozyczenia", hw);
		response.sendRedirect("KlientHistoriaWypozyczenAdmin.jsp");
	
	
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
