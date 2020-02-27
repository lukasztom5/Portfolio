<%@ page import="encje.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
}

#main { background: #eee ;width: 1323px;}

#header {
	height: 45px;
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    width: 1323px;
    background: #666;
}

#content {
    height: 400px;
    background: #eee;
}
ul, ul li {
	display: block;
	list-style: none;
	margin: 0;
	padding: 0;
	text-align: center; 
}

ul {
	float: left;
	background-color: #fff;
	padding: 1px 0 1px 1px;
	border: 1px solid #000;
}

ul li {
	float: left;
}

ul a:link, ul a:visited {
	text-decoration: none;
	display: block;
	font-weight: bold;
	background: #000 url("tlo.gif") repeat-x center;
	color: #fff;
	padding: 10px 102px;
	border-right: 1px solid #fff;
	border-right: 1px solid #fff;
}

ul a:hover {
	background-color: #800;
	background-image: url("tlo2.gif");
}
</style>
</head>
<body>
    <div id="main">
        <div id="header">
         	<ul>
			<li>
				<a href="czesci.jsp">Części AGD</a>
			</li>	
			<li>
				<a href="client.jsp">Klienci</a>
			</li>
			<li>
				<a href="pracownicy.jsp">Pracownicy</a>
			</li>	
			<li>
				<a href="contactAdmin.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li> 
		</ul>   
		</div></div>
        <div class="spacer2"></div>
       
<% 
Integer idpracownik = (Integer) session.getAttribute("idpracownik");
PracownikDaoImpl pdi =new PracownikDaoImpl();
Pracownik p=pdi.findById(idpracownik);
RozliczenieDaoImpl rdi=new RozliczenieDaoImpl();
List<Rozliczenie> list=rdi.findByPracownika(p.getIDPRACOWNIK());
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date();
%>
 <h1>Zatrudnienie</h1>
<div class="CSSTableGenerator">

<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Imie i Nazwisko Zatrudniającego</td>
					    <td>Pensja</td>
					    <td>Data Zatrudnienia</td>
					    <td>Rodzaj Zatrudnienia</td>
					</tr>
					<%for(Rozliczenie r:list){
					%>
				
					<tr>
						
						
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
						RozlWidokDaoImpl rwdi=new RozlWidokDaoImpl();
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();
						RozlWidok rw=rwdi.findByIdrozl(r.getIDROZLICZENIE());
						AdministratorDaoImpl adi=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR().getIDADMINISTRATOR());
						%>
						<%if(!rw.getDataZatrudnienia().equalsIgnoreCase("brak")){%>
						<td><%=r.getIDROZLICZENIE()%></td>
						<td><%=pd.getImie()%></td>
						<td><%=pd.getNazwisko()%></td>
						<td><%=w1.getImie().toString()+" "+w1.getNazwisko().toString()%></td>
							<td><%=rw.getPensja()+ "zł" %></td>	
						<td><%=rw.getDataZatrudnienia()%></td>
					
						<td><%=rw.getRodzajZatrudnienia()%></td>
						<%} %>
	</tr>
					
					
					<%} %>
					
					</table>
				 </div>
				 <br><br>
				 <br><br>
				 <br><br>
 <h1>Rozliczenie z pracy</h1>
<div class="CSSTableGenerator">

<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Imie i Nazwisko Rozliczającego</td>
					    <td>Pensja</td>
					    <td>Data Rozliczenia</td>
					    <td>Premia</td>
					    <td>Szczegóły Premii</td>
					    <td>Kara</td>
					    <td>Szczegóły Kary</td>
					    <td>Wypłata</td>
					    
					    
					</tr>
					<%for(Rozliczenie r:list){
					%>
				
					<tr>
						
						
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
						RozlWidokDaoImpl rwdi=new RozlWidokDaoImpl();
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();
						RozlWidok rw=rwdi.findByIdrozl(r.getIDROZLICZENIE());
						AdministratorDaoImpl adi=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR().getIDADMINISTRATOR());
						%>
						<%if(!rw.getDataRozliczenia().equalsIgnoreCase("brak")){%>
						<td><%=r.getIDROZLICZENIE()%></td>
						<td><%=pd.getImie()%></td>
						<td><%=pd.getNazwisko()%></td>
						<td><%=w1.getImie().toString()+" "+w1.getNazwisko().toString()%></td>
						<td><%=rw.getPensja()+ " zł" %></td>	
						<td><%=rw.getDataRozliczenia()%></td>
					<td><%=rw.getPremia()+ " zł"%></td>
					<td><%=rw.getSzczegolyPremii()%></td>
					<td><%=rw.getKara()+ " zł"%></td>
					<td><%=rw.getSzczegolyKary()%></td>
						<td><%=rw.getWyplata()+ " zł"%></td>
						<%} %>
	</tr>
					
					
					<%} %>
					
					</table>
				 </div>				 
				 <br><br>
				 <br><br>
				 <br><br>
 <h1>Zwolnienie z pracy</h1>
<div class="CSSTableGenerator">

<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Imie i Nazwisko Zwalniającego</td>
					    <td>Data Zwolnienie</td>
					    <td>Przyczyna Zwolnienia</td>
					    
					    
					</tr>
					<%for(Rozliczenie r:list){
					%>
				
					<tr>
						
						
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
						RozlWidokDaoImpl rwdi=new RozlWidokDaoImpl();
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();
						RozlWidok rw=rwdi.findByIdrozl(r.getIDROZLICZENIE());
						AdministratorDaoImpl adi=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR().getIDADMINISTRATOR());
						%>
						<%if(!rw.getDataZwolnienia().equalsIgnoreCase("brak")){%>
						<td><%=r.getIDROZLICZENIE()%></td>
						<td><%=pd.getImie()%></td>
						<td><%=pd.getNazwisko()%></td>
						<td><%=w1.getImie().toString()+" "+w1.getNazwisko().toString()%></td>
						<td><%=rw.getDataZwolnienia()%></td>
					<td><%=rw.getSzczegolyZwolnienia()%></td>
						<%} %>
	</tr>
					
					
					<%} %>
					
					</table>
				 </div>					 
				 	<ul>
				 	<li>
					<a href="Rozlicz.jsp">Dodaj Rozliczenie</a>
					</li>
					</ul>
	 			</div>
			</div>
</div>
        <div id="footer">
            footer
        </div>
</body>
</html>