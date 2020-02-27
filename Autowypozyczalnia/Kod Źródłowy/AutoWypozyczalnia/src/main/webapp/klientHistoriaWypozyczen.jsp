<%@page import="java.util.List"%>
<%@ page import="p.lodz.pl.encje.HistoriaWypozyczenia" %>
<%@ page import="p.lodz.pl.encje.Klient" %>
<%@ page import="p.lodz.pl.dao.HistoriaDaoImpl" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
				<a href="cennik.jsp">Cennik</a>
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
				Twoja historia wypożyczeń
			</h5>
             <div class="spacer2"></div>
       
<% 
Klient idklient = (Klient) session.getAttribute("klient");
HistoriaDaoImpl hdi =new HistoriaDaoImpl();
List<HistoriaWypozyczenia> lista=hdi.findAutaByKlient(idklient.getIdklient());

DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
%>
<div class="CSSTableGenerator">
<table>
					<tr>
						<td>Marka Auta</td>
						<td>Model Auta</td>
						<td>Imie Klienta</td>
						<td>Nazwisko Klienta</td>
						<td>Termin Wypożyczenia</td>
						<td>Termin Oddania</td>
						<td>Liczba Dni</td>
						<td>Cena Segment</td>
						<td>Dodatkowe Wyposazenie</td>
						<td>Cena Za Wyposażenie</td>
						<td>Dodatkowy Koszt</td>
						<td>Całkowita Cena</td>
						<td>Status Zaliczki</td>
						<td>Przejechane Kilometry</td>
						<td>Uwagi</td>
						<td>Wiecej</td>
					</tr>
					<%for(HistoriaWypozyczenia h:lista){
					%>
					
					<tr>
						<td><%=h.getMarka()%></td>
						<td><%=h.getModel()%></td>
						<td><%=h.getImie()%></td>
						<td><%=h.getNazwisko()%></td>
						<td><%=df.format(h.getTerminWypozyczenia())%></td>
						<td><%=df.format(h.getTerminOddania())%></td>
						<td><%=h.getLiczbaDni()%></td>
						<td><%=h.getCenaSegment()+" zł"%></td>
						<td><%=h.getWyposazenie()%></td>
						<td><%=h.getCenaDodatek()+" zł"%></td>
						<td><%=h.getDodatkowyKoszt()+" zł"%></td>
						<td><%=h.getStawkaSegmentWyposazenie()+" zł"%></td>
						<td><%=h.getStatusZaliczka()%></td>
						<td><%=h.getKilometry()+" km"%></td>
						<td><%=h.getUwagi()%></td>
						
						
					<td><a class="more"
							href="HistoriaKlientInfo?idhistoria_wypozyczenia=<%=h.getIdhistoriaWypozyczenia()%>">Szczegóły</a></td>
					</tr>
					
					<%} %>
					
					</table>
					</div>
        <div class="cleaner"></div>
        </div>
        		<ul>
			<li>
					<a href="klientAktualneWypozyczenia.jsp">Aktualne Wypożyczenia</a>
					</li>
					</ul>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>