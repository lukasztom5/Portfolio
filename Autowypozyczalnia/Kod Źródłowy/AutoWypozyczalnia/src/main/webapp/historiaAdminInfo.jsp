<%@page import="java.util.List"%>
<%@page import="java.lang.*"%>
<%@ page import="p.lodz.pl.encje.HistoriaWypozyczenia" %>
<%@ page import="p.lodz.pl.encje.Klient" %>
<%@ page import="p.lodz.pl.dao.HistoriaDaoImpl" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl"%>
<%@ page import="p.lodz.pl.dao.WyposazenieDaoImpl"%>
<%@ page import="p.lodz.pl.encje.Wyposazenie"%>
<%@ page import="p.lodz.pl.encje.Auta"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

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
    width: 1425px;
}

#main { background: #eee }

#header {
    height: 45px;    
    background: #666;
    width: 1425px;
}

#footer {
    height: 45px;
    clear: left;
    background: #666;
    width: 1425px;
}

#content {
    height: 400px;
    background: #eee;
     width: 1400px;
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
	padding: 10px 115px;
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
				<a href="contactAdmin.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li> 
		</ul>   
            
        </div>
<h5 style="line-height: 31px">
				Szczegóły wypożyczenia
			</h5>
             <div class="spacer2"></div>
       
<% 
Integer idhistoria_wypozyczenia=(Integer) session.getAttribute("idhistoria_wypozyczenia");
HistoriaDaoImpl hdi=new HistoriaDaoImpl();
HistoriaWypozyczenia h=hdi.findById(idhistoria_wypozyczenia);


AutoDaoImpl ado =new AutoDaoImpl();
Auta a=ado.findAutaByModelMarka(h.getMarka().toString(), h.getModel().toString());
Double i=new Double(h.getCenaDodatek());

DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
%>
<div class="CSSTableGenerator">
<table>
					<tr>
					<td>Numer Id</td>
						<td>Id Klienta</td>
						<td>Id Auta</td>
						<td>Marka Auta</td>
						<td>Model Auta</td>
						<td>Segment</td>
						<td>Imie Klienta</td>
						<td>Nazwisko Klienta</td>
						<td>Data Wypożyczenia</td>
						<td>Data Oddania</td>
						<td>Liczba Dni</td>
						<td>Cena Segment</td>
						<td>Cena Dodatek</td>
						<td>Wyposazenie</td>
						<td>Całkowita Cena</td>
						<td>Dodatkowy Koszt</td>
						<td>Przejechane Kilometry</td>
						<td>Status Zaliczki</td>
						<td>Uwagi</td>
					</tr>
					
					<tr>
					<td><%=h.getIdhistoriaWypozyczenia()%></td>
						<td><%=h.getKlientid()%></td>
						<td><%=h.getAutoId()%></td>
						<td><%=h.getMarka()%></td>
						<td><%=h.getModel()%></td>
						<td><%=a.getSegment()%></td>
						<td><%=h.getImie()%></td>
						<td><%=h.getNazwisko()%></td>
						<td><%=df.format(h.getTerminWypozyczenia())%></td>
						<td><%=df.format(h.getTerminOddania())%></td>
						<td><%=h.getLiczbaDni()%></td>
						<td><%=h.getCenaSegment()+" zł"%></td>
						<td><%=h.getCenaDodatek()+" zł"%></td>
						<td><%=h.getWyposazenie()%></td>
						<td><%=h.getStawkaSegmentWyposazenie()+" zł"%></td>
						<td><%=h.getDodatkowyKoszt()+" zł"%></td>
						<td><%=h.getKilometry()+" km"%></td>
					<td><%=h.getStatusZaliczka()%></td>
					<td><%=h.getUwagi()%></td>
					
					
					</table>
					</div>
        <div class="cleaner"></div>
        </div>
        		<ul>
					</ul>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>