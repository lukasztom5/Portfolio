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

public class DodajKategoria extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		KategoriaDaoImpl kdi=new KategoriaDaoImpl();
		Integer idkat=kdi.NewIdKategoria();
		KatalogDodaj uddi= new KatalogDodaj();
		List<Urzadzenie> lista=uddi.findbynazwa(request.getParameter("urzadzenie"));
		for(Urzadzenie u:lista){
		String dane="<kategoria><idkategoria ik=\""+idkat+"\">"+idkat
										+ "</idkategoria>"
				+ "<nazwa nazwa=\""+request.getParameter("rodzaj")+"\">"+request.getParameter("rodzaj")
						+ "</nazwa></kategoria>";


		Kategoria model= new Kategoria(idkat,u,dane);
		
		try{
			DodajKatalogService krs=new DodajKatalogService();
			boolean r=krs.dodaj(model);
			if(r){
				request.getSession().setAttribute("idkategoria", idkat.toString());
				response.sendRedirect("kategoria.jsp");
			}
			else {

				response.sendRedirect("bladdodawaniakategorii.jsp");
			}
		
		}finally{
			pw.close();
		}
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
