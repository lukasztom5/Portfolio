<%@ page import="encje.Pracownik" %>
<%@ page import="encje.PracDane" %>
<%@ page import="dao.PracownikDaoImpl" %>
<%@ page import="dao.PracDaneDaoImpl" %>
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
%>
 
 <div class="CSSTableGenerator">
<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
					    <td>Imie i Nazwisko</td>
					    <td>Kod</td>
					    <td>Kraj</td>
					    <td>Miasto</td>
					    <td>Adres</td>
					    <td>Adres Mail</td>
					    <td>Telefon</td>
					    <td>Telefon Służbowy</td>
					     <td>Numer Konta</td>
					    <td>Zarobki</td>
					     <td>Data Zatrudnienia</td>
					    <td>Data Zakończenia Pracy</td>
					    <td>Login</td>
					    <td>Haslo</td>
					</tr>
					<tr>
						<td><%=p.getIDPRACOWNIK()%></td>
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());%>
						
						<td><%=pd.getImie()+ " "+ pd.getNazwisko()%></td>
						<td><%=pd.getKod()%></td>
						<td><%=pd.getKraj()%></td>
						<td><%=pd.getMiasto()%></td>
						<td><%=pd.getAdres()%></td>
						<td><%=pd.getAdresMail()%></td>
						<td><%=pd.getTelefon()%></td>
						<td><%=pd.getTelefonSlużbowy()%></td>
						<td><%=pd.getNumerKonta()%></td>
						<td><%=pd. getPensja()+" zł"%></td>
						<td><%=pd.getDataZatrudnienia()%></td>
						<td><%=pd.getDataZakonczenia()%></td>
						<td><%=p.getLOGIN()%></td>
						<td><%=p.getHASLO()%></td>
					</tr>				
					</table>
				 </div>
				 	<ul>
				 	<li>
					<a href="PracownikRozliczenieAdmin.jsp">Rozliczenia</a>
					</li>
			<li>
					<a href="PracownikAktualneZamowieniaAdmin.jsp">Aktualne Zamówienia</a>
					</li>
					<li>
					<a href="PracownikHistoriaZamowieniaAdmin.jsp">Historia Zamówień</a>
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