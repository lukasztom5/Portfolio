<%@page import="java.util.List"%>
<%@ page import="p.lodz.pl.encje.Auta" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    width: 1413px;
}

#main { background: #eee }

#header {
    height: 45px;    
    background: #666;
    width: 1413px;
}

#footer {
    height: 45px;
    clear: left;
    background: #666;
   width: 1413px;
}

#content {
    height: 400px;
    background: #eee;
    width: 1413px;
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
	padding: 10px 116px;
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
				<a href="cennikKlient.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalogclient.jsp">Katalog</a>
			</li>
			<li>
				<a href="klientHistoriaWypozyczen.jsp">Historia</a>
			</li>	
			<li>
				<a href="contactklient.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		       </li>
		</ul>   
            
        </div>
        <h5 style="line-height: 31px">
				Samochody aktualnie dostępne w wypożyczalnii
			</h5>
             <div class="spacer2"></div>
       
<% AutoDaoImpl Ado =new AutoDaoImpl();
List<Auta> lista=Ado.findWolneAuta();
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
						<td>Wypożycz</td>
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
						<td><a class="more"
							href="AutoWypozycz?idauto=<%=a.getIdauta()%>">Wypożycz</a></td>
					</tr>
					
					
					<%} %>
					
					</table>
					</div>
					<div class="cleaner"></div>
        </div>
        <ul>
			<li>
					<a href="szukaj.jsp">Znajdź</a>
					</li>
					</ul>
        <div id="footer">
            footer
        </div>
</body>
</html>