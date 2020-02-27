package kontroler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import encje.*;
import server.*;

public class DodajUrzadzenie extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		UrzadzenieDaoImpl udi=new UrzadzenieDaoImpl();
		Integer idurzadzenie=udi.NewIdUrzadz();
		
		String dane="<urzadzenie><idurzadzenie idurzadzenie=\""+idurzadzenie+"\">"+idurzadzenie+
				"<nazwa nazwa=\""+request.getParameter("nazwa")+"\">"+request.getParameter("nazwa")	
				
										+ "</nazwa></idurzadzenie></urzadzenie>";;
		Urzadzenie u=new Urzadzenie(idurzadzenie,dane);
		try{
			UrzadzenieRegistryService urs = new UrzadzenieRegistryService();
			boolean r=urs.dodaj(u);
			if(r){
				request.getSession().setAttribute("idurzadzenie", idurzadzenie.toString());
				response.sendRedirect("czesci.jsp");
			}
			else {

				response.sendRedirect("bladdodawaniaurzadzenia.jsp");
			}
		
		}finally{
			pw.close();
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
