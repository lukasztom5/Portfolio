package p.lodz.pl.wypozyczalnia.kontroler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p.lodz.pl.encje.Auta;
import p.lodz.pl.serwer.ZnajdzAutoService;

@WebServlet(name="ZnajdzAuto",urlPatterns={"/ZnajdzAuto"})
public class ZnajdzAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String marka=request.getParameter("marka");
		String segment=request.getParameter("segment");
		String paliwo=request.getParameter("paliwo");
		String skrzynia_biegow=request.getParameter("skrzynia_biegow");
		String naped_na_kola=request.getParameter("naped_na_kola");
		String liczba_miejsc=request.getParameter("liczba_miejsc");
		String liczba_drzwi=request.getParameter("liczba_drzwi");
		
		ZnajdzAutoService ZnajdzAutoService=new ZnajdzAutoService();
		List<Auta> listaAut= new ArrayList<Auta>();
		if(marka!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("marka",marka);
		else if(segment!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("segment",segment);
		else if(paliwo!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("paliwo",paliwo);
		else if(skrzynia_biegow!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("skrzynia_biegow",skrzynia_biegow);
		else if(naped_na_kola!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("naped_na_kola",naped_na_kola);
		else if(liczba_miejsc!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("liczba_miejsc",liczba_miejsc);
		else if(liczba_drzwi!=null)
			listaAut=ZnajdzAutoService.findautabycolumn("liczba_drzwi",liczba_drzwi);
		
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
