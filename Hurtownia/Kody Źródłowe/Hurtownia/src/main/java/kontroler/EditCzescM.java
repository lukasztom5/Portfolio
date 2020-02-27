package kontroler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import encje.*;
import server.*;

@WebServlet(name = "EditCzescM", urlPatterns = { "/EditCzescM" })
public class EditCzescM extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Czesc kd=(Czesc)request.getSession().getAttribute("CZESC");
		String id=request.getParameter("idczesc");
		String dane="<czesc><idczesc id=\""+id+"\">"+id
				+ "</idczesc><obraz obraz=\""+request.getParameter("link")+"\">"+request.getParameter("link")+"</obraz>"
				+ "<nazwa n=\""+request.getParameter("nazwa")+"\">"+request.getParameter("nazwa")
+ "<cena c=\""+request.getParameter("cena")+"\">"+request.getParameter("cena")
+ "</cena><sztuki sz=\""+request.getParameter("ilosc")+"\">"+request.getParameter("ilosc")
+ "</sztuki></nazwa></czesc>";
		
EditCzescMService kms=new EditCzescMService();
kd=kms.edycja(kd, dane);
request.getSession().setAttribute("CZESC", kd);
response.sendRedirect("czescipomodel.jsp");	
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
