package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.encje.AktualneWypozyczenie;
import p.lodz.pl.serwer.AktualneEditService;

@WebServlet(name = "AktualneEdit", urlPatterns = { "/AktualneEdit" })
public class AktualneEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		response.setContentType("text/html;charset=UTF-8");
		
		AktualneWypozyczenie aw=(AktualneWypozyczenie)request.getSession().getAttribute(
				"aktualne_wypozyczenie");
		String DataZwrotu=request.getParameter("dataZwrotu");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		AktualneEditService aes=new AktualneEditService();
		aw=aes.edycja(aw, formatter.parse(DataZwrotu));
		
		request.getSession().setAttribute("aktualne_wypozyczenie", aw);
		response.sendRedirect("KlientAktualneWypozyczeniaAdmin.jsp");
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
