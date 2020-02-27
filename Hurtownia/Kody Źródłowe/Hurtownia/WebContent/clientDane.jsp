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
				<a href="clientDane.jsp">Dane</a>
			</li>
			<li>
				<a href="catalogclient.jsp">Katalog</a>
			</li>
			<li>
				<a href="zamowieniaKlient.jsp">Twoje Zamówienia</a>
			</li>	
			<li>
				<a href="contactklient.jsp">Kontakt</a>
			</li>
		    <li>
		       <a href="index.jsp">Wyloguj</a>
		       </li> 
		</ul>   
		</div></div>
        <div class="spacer2"></div>
       
<% 
Klient klient = (Klient) session.getAttribute("klient");
KlientDaoImpl kdi =new KlientDaoImpl();
Klient k=kdi.findById(klient.getIDKLIENT());
%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
						<td>Imie</td>
						<td>Nazwisko</td>
						<td>Kraj</td>
						<td>Miasto</td>
						<td>Zakład</td>
						<td>Adres</td>
						<td>Adres Mail</td>
						<td>Telefon</td>
						<td>Login</td>
						<td>Hasło</td>
						<td>Edytuj</td>
					</tr>
					<tr>
						<%	KlientDaneDaoImpl kdi1 =new KlientDaneDaoImpl();
						KlientDane kd=kdi1.findByIdklient(k.getIDKLIENT());%>
						
						<td><%=kd.getImie()%></td>
						<td><%=kd.getNazwisko()%></td>
						<td><%=kd.getKraj()%></td>
						<td><%=kd.getMiasto()%></td>
						<td><%=kd.getZaklad()%></td>
						<td><%=kd.getAdres()%></td>
						<td><%=kd.getAdres_mail()%></td>
						<td><%=kd.getTelefon()%></td>
						<td><%=k.getLOGIN()%></td>
						<td><%=k.getHASLO()%></td>
						<td><a class="more"
							href="ZmienDane?idklient=<%=k.getIDKLIENT()%>">Edytuj</a></td>
					</tr>				
					</table>
				 </div>
        <div id="footer">
            footer
        </div>
</body>
</html>