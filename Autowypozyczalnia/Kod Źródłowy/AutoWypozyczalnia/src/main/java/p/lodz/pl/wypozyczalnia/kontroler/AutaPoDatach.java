package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.encje.Auta;
import p.lodz.pl.serwer.PoDatachService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="AutaPoDatach",urlPatterns={"/AutaPoDatach"})
public class AutaPoDatach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
	
	PoDatachService pd=new PoDatachService();
	List<Auta> listaAut= new ArrayList<Auta>();
	listaAut=pd.findautabydata(request.getParameter("data1"), request.getParameter("data2"));
	
	if(listaAut.size()>0){
		request.getSession().setAttribute("listaAut", listaAut);
		response.sendRedirect("autapodacie.jsp");
	}else{
		response.sendRedirect("niedostepne.jsp");
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
