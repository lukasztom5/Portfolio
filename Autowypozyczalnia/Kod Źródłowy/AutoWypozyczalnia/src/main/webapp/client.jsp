<%@ page import="p.lodz.pl.encje.Klient" %>
<%@ page import="p.lodz.pl.dao.KlientDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Wypożyczalnia samochodów</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
}

#main { background: #eee }

#header {
    height: 45px;    
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    background: #666;
}

#content {
    height: 700px;
    background: #eee;
}
ul, ul li {
	display: block;
	list-style: none;
	margin: 0;
	padding: 0;
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
	padding: 10px 110px;
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
				<a href="cennikAdmin.jsp">Cennik</a>
			</li>	
			<li>
				<a href="client.jsp">Klienci</a>
			</li>
			<li>
				<a href="auta.jsp">Samochody</a>
			</li>	
			<li>
				<a href="contact.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li> 
		</ul>   
            
        </div>
         </div>
        <div class="spacer2"></div>
       
<% KlientDaoImpl kdi =new KlientDaoImpl();
List<Klient> lista=kdi.findAll();
%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
						<td>Imie</td>
						<td>Nazwisko</td>
						<td>Pesel</td>
						<td>Miasto</td>
						<td>Adres</td>
						<td>Adres Mail</td>
						<td>Telefon</td>
						<td>Login</td>
						<td>Hasło</td>
						<td>Więcej</td>
						<td>Usuń</td>
					</tr>
					<%for(Klient k:lista){
					%>
					
					<tr>
						<td><%=k.getIdklient()%></td>
						<td><%=k.getImie()%></td>
						<td><%=k.getNazwisko()%></td>
						<td><%=k.getPesel()%></td>
						<td><%=k.getMiasto()%></td>
						<td><%=k.getAdres()%></td>
						<td><%=k.getAdresMail()%></td>
						<td><%=k.getTelefon()%></td>
						<td><%=k.getLogin()%></td>
						<td><%=k.getHaslo()%></td>
						<td><a class="more"
							href="KlientInfo?idklient=<%=k.getIdklient()%>">Szczegóły</a></td>
						<td><a class="more"
							href="UsunKlient?idklient=<%=k.getIdklient()%>">Usuń</a></td>
						<td>
						</td>
					</tr>
					
					
					<%} %>
					
					</table>
					</div>
					<div class="cleaner"></div>
					<ul>
					</ul>

         <div id="footer">
            Wypożyczalnia 2015
        </div>
</body>
</html>