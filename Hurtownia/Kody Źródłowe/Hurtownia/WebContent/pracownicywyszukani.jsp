<%@ page import="encje.*" %>
<%@ page import="dao.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Hurtownia</title>
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
            
        </div>
         </div>
        <div class="spacer2"></div>
 <h5 style="line-height: 31px">
				Wyszukani Pracownicy
			</h5>
             <div class="spacer2"></div>      
<%
List<Pracownik> lista=(List<Pracownik>) session.getAttribute("lista");

%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
					    <td>Imie i Nazwisko Pracownika</td>
					    <td>Imie i Nazwisko Kierownika</td>
					    <td>Kraj</td>
					    <td>Miasto</td>
					    <td>Adres</td>
					    <td>Adres Mail</td>
					    <td>Telefon</td>
					    <td>Telefon Służbowy</td>
					    <td>Login</td>
					    <td>Haslo</td>
					    <td>Zatrudnienie</td>
					    <td>Szczegóły</td>
					    <td>Edytuj</td>
					    <td>Wypowiedzenie</td>
					    <td>Usuń</td>
					</tr>
					<%for(Pracownik p:lista){
					%>
				
					<tr>
						
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();

						AdministratorDaoImpl adi=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR().getIDADMINISTRATOR());
						%>
						
						<td><%=pd.getImie()+" "+pd.getNazwisko()%></td>
						<td><%=w1.getImie().toString()+" "+w1.getNazwisko().toString()%></td>
						<td><%=pd.getKraj()%></td>
						<td><%=pd.getMiasto()%></td>
						<td><%=pd.getAdres()%></td>
						<td><%=pd.getAdresMail()%></td>
						<td><%=pd.getTelefon()%></td>
						<td><%=pd.getTelefonSlużbowy()%></td>
						<td><%=p.getLOGIN()%></td>
						<td><%=p.getHASLO()%></td>
																		<td><a class="more"
							href="RozliczZatrudnienie?idpracownik=<%=p.getIDPRACOWNIK()%>">Umowa</a></td>
												<td><a class="more"
							href="MorePracownik?idpracownik=<%=p.getIDPRACOWNIK()%>">Szczegóły</a></td>
						
												<td><a class="more"
							href="PracownikInfo?idpracownik=<%=p.getIDPRACOWNIK()%>">Edytuj</a></td>
						<td><a class="more"
							href="Zwolnij?idpracownik=<%=p.getIDPRACOWNIK()%>">Wypowiedzenie</a></td>
						
						<td><a class="more"
							href="UsunPracownika?idpracownik=<%=p.getIDPRACOWNIK()%>">Zwolnij</a></td>
						
					</tr>
					
					
					<%} %>
					
					</table>
					<ul>
			<li>
					<a href="zatrudnij.jsp">Zatrudnij</a>
					</li>
					<li>
					<a href="szukajpracownika.jsp">Szukaj</a>
					</li>
					</div>
					<div class="cleaner"></div>
					<ul>
					</ul>

         <div id="footer">
        </div>
</body>
</html>