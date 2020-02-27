package kontroler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class DodajCzescM extends HttpServlet{
	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		CzescDaoImpl kdi=new CzescDaoImpl();
		Integer idcz=kdi.NewIdCzesc();
		KatalogDodaj uddi= new KatalogDodaj();
		List<Model> lista=uddi.findbynazwa1(request.getParameter("idmodel"));
		List<Kategoria> lista1=uddi.findbynazwa2(request.getParameter("idkat"));
		for(Model u:lista){
			for(Kategoria u1:lista1){
		
		
		String dane="<czesc><idczesc id=\""+idcz+"\">"+idcz
										+ "</idczesc><obraz obraz=\""+request.getParameter("link")+"\">"+request.getParameter("link")+"</obraz>"
										+ "<nazwa n=\""+request.getParameter("nazwa")+"\">"+request.getParameter("nazwa")
						+ "<cena c=\""+request.getParameter("cena")+"\">"+request.getParameter("cena")
						+ "</cena><sztuki sz=\""+request.getParameter("ilosc")+"\">"+request.getParameter("ilosc")
						+ "</sztuki></nazwa></czesc>";


		Czesc c=new Czesc(idcz,u1,u,dane);
		try{
			DodajCzescMService krs=new DodajCzescMService();
			boolean r=krs.dodaj(c);
			if(r){
				request.getSession().setAttribute("idczesc", idcz.toString());
				response.sendRedirect("czescipomodel.jsp");
			}
			else {

				response.sendRedirect("bladdodawaniaczescipomodel.jsp");
			}
		
		}finally{
			pw.close();
		}}}
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
