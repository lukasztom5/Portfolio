package kontroler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.EditCzescMService;
import dao.*;
import encje.*;

@WebServlet(name="WyjmijzKoszyka", urlPatterns={"/WyjmijzKoszyka"})
public class WyjmijzKoszyka extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		int idzakup = Integer.parseInt(request.getParameter("idzakup"));
		KoszykDaoImpl kdd = new KoszykDaoImpl();
		Koszyk w = kdd.findById(idzakup);
		CzescDaoImpl cdi = new CzescDaoImpl();
		Czesc c= cdi.findById(w.getIdczesc().getIDCZESC());
		CzescDaneDaoImpl cddi = new CzescDaneDaoImpl();
		CzescWidok cw= cddi.findByIdczesc(c.getIDCZESC());
		AktualneDaoImpl adi = new AktualneDaoImpl();
		HistoriaDaoImpl hdi = new HistoriaDaoImpl();
		AktualneZamowienia az = adi.findById(idzakup);
		KoszykDaneDaoImpl kddd = new KoszykDaneDaoImpl();
		KoszykDane kd = kddd.findByIdkosz(w.getIdkoszyk());
		String dane1="<czesc><idczesc id=\""+c.getIDCZESC()+"\">"+c.getIDCZESC()
				+ "</idczesc><obraz obraz=\""+cw.getObraz()+"\">"+cw.getObraz()+"</obraz>"
				+ "<nazwa n=\""+cw.getNazwa()+"\">"+cw.getNazwa()
+ "<cena c=\""+cw.getCena()+"\">"+cw.getCena()
+ "</cena><sztuki sz=\""+(cw.getIlosc()+Integer.parseInt(kd.getLiczba()))+"\">"+(cw.getIlosc()+Integer.parseInt(kd.getLiczba()))
+ "</sztuki></nazwa></czesc>";
		
	EditCzescMService kms=new EditCzescMService();	
	KoszykDaoImpl kdi = new KoszykDaoImpl();
	c=kms.edycja(c, dane1);
	hdi.removeById(az.getIDAKTUALNEZAMOWIENIE());
	adi.removeById(az.getIDAKTUALNEZAMOWIENIE());
	
	kdi.removeById(idzakup);
	
	response.sendRedirect("zamowienie.jsp");
	
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
