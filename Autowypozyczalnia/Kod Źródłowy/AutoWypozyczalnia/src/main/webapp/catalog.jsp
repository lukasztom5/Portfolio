<%@page import="java.util.List"%>
<%@ page import="p.lodz.pl.encje.Auta" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="p.lodz.pl.encje.Auta"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Wypożyczalnia samochodów</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
    width: 100%;
}

#main { background: #eee;
 width: 1413px; }

#header {
    height: 45px;  
     width: 1413px;
    background: #666;
    
}

#footer {
    height: 45px;
      width: 1413px;
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
	padding: 10px 113px;
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
				<a href="cennik.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalog.jsp">Katalog</a>
			</li>
			<li>
				<a href="login.jsp">Logowanie</a>
			</li>
			<li>
				<a href="registry.jsp">Rejestracja</a>
			</li>	
			<li>
				<a href="contact.jsp">Kontakt</a>
			</li>
		</ul>             
        </div>
        <h5 style="line-height: 31px">
				Samochody dostepne w wypozyczalnii
			</h5>
             <div class="spacer2"></div>
       
<% AutoDaoImpl Ado =new AutoDaoImpl();
List<Auta> lista=Ado.findAll();
%>
<div class="CSSTableGenerator">
<table>
					<tr>
						<td>Marka</td>
						<td>Model</td>
						<td>Segment</td>
						<td>Paliwo</td>
						<td>Skrzynia Biegow</td>
						<td>Numer Rejestracyjny</td>
						<td>Rocznik</td>
						<td>Kolor</td>
						<td>Moc Silnika KM</td>
						<td>Naped Na Kola</td>
						<td>Liczba Miejsc</td>
						<td>Liczba Drzwi</td>
						<td>Pojemnosc Bagaznika litry</td>
						<td>Zuzycie paliwa na 100 km</td>
					</tr>
					<%for(Auta a:lista){
					%>
					
					<tr>
					
						<td><%=a.getMarka()%></td>
						<td><%=a.getModel()%></td>
						<td><%=a.getSegment()%></td>
						<td><%=a.getPaliwo()%></td>
						<td><%=a.getSkrzyniaBiegow()%></td>
						<td><%=a.getNumerRejestracyjny()%></td>
						<td><%=a.getRocznik()%></td>
						<td><%=a.getKolor()%></td>
						<td><%=a.getMoc_silnika_KM()%></td>
						<td><%=a.getNapedNaKola()%></td>
						<td><%=a.getLiczbaMiejsc()%></td>
						<td><%=a.getLiczbaDrzwi()%></td>
						<td><%=a.getPojemnoscBagaznikaWLitrach()%></td>
						<td><%=a.getZuzyciePaliwaNa100Km()%></td>
						<%} %>
					</tr>
					</table>
					<h5 style="line-height: 31px">
				Galeria samochodów
			</h5>
					<img src="obrazki/Fiat Panda.jpg" width="280" height="165"/>Fiat Panda
					<img src="obrazki/Ford Ka.jpg" />Ford Ka
					<img src="obrazki/Skoda Citigo.JPG" width="280" height="165"/>Skoda Citigo
					<img src="obrazki/Renault Twingo.jpg" width="280" height="165"/>Renault Twingo
					<img src="obrazki/Toyota Aygo.jpg" width="280" height="165"/>Toyota Aygo
					<img src="obrazki/Chevrolet Spark.jpg" width="280" height="165"/>Chevrolet Spark
					<img src="obrazki/Ford Fiesta.jpg" width="280" height="165"/>Ford Fiesta
					<img src="obrazki/Suzuki Swift.jpg" width="200" height="165"/>Suzuki Swift
					<img src="obrazki/Seat Ibiza.jpg" width="280" height="165"/>Seat Ibiza
					<img src="obrazki/Skoda Fabia.jpg" width="280" height="165"/>Skoda Fabia
					<img src="obrazki/Renault Clio.jpg" width="280" height="165"/>Renault Clio
					<img src="obrazki/Citroen C3.jpg" width="280" height="165"/>Citroen C3
					</div>
					<div class="cleaner"></div>
        </div>
         <div id="footer">
            footer
        </div>
</body>
</html>