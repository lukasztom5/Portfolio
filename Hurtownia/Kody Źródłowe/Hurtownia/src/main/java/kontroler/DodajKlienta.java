package kontroler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KlientDaoImpl;
import encje.Klient;
import server.ClientRegistry;

public class DodajKlienta extends HttpServlet{

	private static final long serialVersionUID = -5554371485391595568L;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		KlientDaoImpl kdi=new KlientDaoImpl();
		Integer idklient=kdi.NewIdKlient();
		
		String dane="<klient><idklient id=\""+idklient+"\">"+idklient
				+"<kod kod=\""+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "+request.getParameter("login")+"\">"
				+request.getParameter("imie")+" "+request.getParameter("nazwisko")+" - "+request.getParameter("login")
				+ "</kod></idklient>"
				+ "<kraj country=\""+request.getParameter("kraj")+"\">"+request.getParameter("kraj")
				+ "<miasto city=\""+request.getParameter("miasto")+"\">"+request.getParameter("miasto")
				+"<zaklad zak=\""+request.getParameter("zaklad")+"\">"+request.getParameter("zaklad")
						+ "<adres adr=\""+request.getParameter("adres")+"\">"+request.getParameter("adres")
								+ "</adres></zaklad></miasto></kraj>"
								+ "<nazwisko surname=\""+request.getParameter("nazwisko")+"\">"+request.getParameter("nazwisko")
										+ "<imie name=\""+request.getParameter("imie")+"\">"+request.getParameter("imie")
										+"</imie></nazwisko>"
										+"<adres_mail am=\""+request.getParameter("adres_mail")+"\">"+request.getParameter("adres_mail")
												+ "</adres_mail>"
										+"<telefon tel=\""+request.getParameter("telefon")+"\">"+request.getParameter("telefon")
										+ "</telefon></klient>";

		String login=request.getParameter("login");
		String haslo=request.getParameter("haslo");	
		Klient klient= new Klient(idklient, dane, login, haslo);
		try{
			ClientRegistry krs=new ClientRegistry();
			boolean r=krs.rejestracja(klient);
			if(r){
				request.getSession().setAttribute("idklient", idklient.toString());
				response.sendRedirect("client.jsp");
			}
			else {

				response.sendRedirect("bladdodawaniaklienta.jsp");
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
