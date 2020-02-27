package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.encje.Auta;
import p.lodz.pl.serwer.ZnajdzAutoService;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name="ZnajdzAutoPoDatach",urlPatterns={"/ZnajdzAutoPoDatach"})
public class ZnajdzAutoPoDatach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		
	ZnajdzAutoService ZnajdzAutoService=new ZnajdzAutoService();
	List<Auta> listaAut= new ArrayList<Auta>();
	
	
		listaAut=ZnajdzAutoService.findautabydata(request.getParameter("data1"), request.getParameter("data2"));
		
	if(listaAut.size()>0){
		request.getSession().setAttribute("listaAut", listaAut);
		response.sendRedirect("wyszukane.jsp");
	}else{
		response.sendRedirect("brakwynikow.jsp");
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
