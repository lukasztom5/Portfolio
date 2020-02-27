<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<%@ page contentType="text/html;charset=UTF-8" %>
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
<body id="home">
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
       <div class="spacer2"></div>
<% Klient admin = (Klient) session.getAttribute("klient");

KategoriaDaoImpl k1 = new KategoriaDaoImpl();
KatDaneDaoImpl kddi = new KatDaneDaoImpl();
ModelDaoImpl mdi = new ModelDaoImpl();
ModelDaneDaoImpl mddi = new ModelDaneDaoImpl();
KoszykDaoImpl kdi1 = new KoszykDaoImpl();
KoszykDaneDaoImpl kddo= new KoszykDaneDaoImpl();
CzescDaoImpl cdi = new CzescDaoImpl();
CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
List<Koszyk> list=kdi1.findByIdkl(admin.getIDKLIENT());


%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
					   <td>Model</td>
					    <td>Zdjęcie</td>
					    <td>Kategoria</td>
					    <td>Nazwa</td>
					    <td>Zdjęcie</td>
					    <td>Ilosc</td>
					     <td>Cena</td>
					     
					</tr>
					
					<%
					float wynik=0;
					for(Koszyk k: list){
						KoszykDaneDaoImpl kddi1 = new KoszykDaneDaoImpl();
						KoszykDane kd = kddi1.findByIdkosz(k.getIdkoszyk());
						CzescDaoImpl cdi1 = new CzescDaoImpl();
						Czesc c1=cdi1.findById(k.getIdczesc().getIDCZESC());
						CzescDaneDaoImpl kdi3 =new CzescDaneDaoImpl();
						CzescWidok kd5=kdi2.findByIdczesc(c1.getIDCZESC());
						ModelDaoImpl mdi1 = new ModelDaoImpl();
						Model m1 = mdi1.findById(c1.getIDMODEL().getIDMODEL());
						ModelDaneDaoImpl mddi1 = new ModelDaneDaoImpl();
						ModelDane md1= mddi1.findByIdmodel(m1.getIDMODEL());
						KategoriaDaoImpl k2 = new KategoriaDaoImpl();
						Kategoria kat1=k2.findById(c1.getIDKATEGORIA().getIDKATEGORIA());
						KatDaneDaoImpl kddi2 = new KatDaneDaoImpl();
						KatWidok kw1= kddi2.findByIdkat(kat1.getIDKATEGORIA());
						KoszykDaneDaoImpl kii = new KoszykDaneDaoImpl();
						KoszykDane kk = kii.findByIdkosz(k.getIdkoszyk());
						Float.parseFloat(kk.getCena());
						wynik+=Float.parseFloat(kk.getCena());
						
					%>
					<tr>
					<td><%=md1.getModel()%></td>
					<td><img src="<%=md1.getLink()%>" width="120" height="120"/></td>
						<td><%=kw1.getNazwa()%></td>
						<td><%=kk.getProdukt()%></td>
						<td><img src="<%=kd5.getObraz()%>" width="120" height="120"/></td>
						<td><%=kk.getLiczba()%></td>
					<td><%=Float.parseFloat(kk.getCena())+" zł"%></td>
					</tr>
					<%} %>
					<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Suma</td>
					<td><%=Float.toString(wynik)+" zł"%></td>
					</tr>
					</table>
					
					
	<ul>
<li>
<a href="catalogclient.jsp">Wyjdź</a>
</li>
</ul>		
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
</body>
</html>