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

public class DodajModel extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		ModelDaoImpl kdi=new ModelDaoImpl();
		Integer idmodel=kdi.NewIdModel();
		KatalogDodaj uddi= new KatalogDodaj();
		List<Urzadzenie> lista=uddi.findbynazwa(request.getParameter("urzadzenie"));
		for(Urzadzenie u:lista){
		
		
		
		String dane="<model><idmodel idmodel=\""+idmodel+"\">"+idmodel
										+ "</idmodel>"
				+"<obraz obraz=\""+request.getParameter("link")+"\">"+request.getParameter("link")+"</obraz>"					
				+ "<firma firma=\""+request.getParameter("firma")+"\">"+request.getParameter("firma")
				+ "<model model=\""+request.getParameter("model")+"\">"+request.getParameter("model")
				+"</model></firma></model>";


		Model model= new Model(idmodel,u,dane);
		try{
			ModelRegistry krs=new ModelRegistry();
			boolean r=krs.dodaj(model);
			if(r){
				request.getSession().setAttribute("idmodel", idmodel.toString());
				response.sendRedirect("modele.jsp");
			}
			else {

				response.sendRedirect("bladdodawaniamodelu.jsp");
			}
		
		}finally{
			pw.close();
		}}
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
