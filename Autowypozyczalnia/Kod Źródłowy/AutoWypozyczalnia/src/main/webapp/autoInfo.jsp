<%@ page import="p.lodz.pl.encje.Auta"%>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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

#main { background: #eee }

#header {
    height: 45px;    
    background: #666;
    width: 1470px;
}

#footer {
    height: 45px;
    clear: left;
    width: 1470px;
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
	padding: 10px 120px;
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
         </div>
        <div class="spacer2"></div>
       
<% 
Integer idauta = (Integer) session.getAttribute("idauto");
AutoDaoImpl Ado =new AutoDaoImpl();
Auta a=Ado.findById(idauta);
%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
					    <td>Numer Identyfikacyjny</td>
						<td>Marka</td>
						<td>Model</td>
						<td>Segment</td>
						<td>Paliwo</td>
						<td>Skrzynia Biegow</td>
						<td>Numer Rejestracyjny</td>
						<td>Numer VIN</td>
						<td>Numer Nadwozia</td>
						<td>Numer Silnika</td>
						<td>Rocznik</td>
						<td>Kolor</td>
						<td>Moc Silnika KM</td>
						<td>Naped Na Kola</td>
						<td>Liczba Miejsc</td>
						<td>Liczba Drzwi</td>
						<td>Pojemnosc Bagaznika litry</td>
						<td>Zuzycie paliwa na 100 km</td>
					</tr>
					<tr>
					    <td><%=a.getIdauta() %></td>
						<td><%=a.getMarka()%></td>
						<td><%=a.getModel()%></td>
						<td><%=a.getSegment()%></td>
						<td><%=a.getPaliwo()%></td>
						<td><%=a.getSkrzyniaBiegow()%></td>
						<td><%=a.getNumerRejestracyjny()%></td>
						<td><%=a.getNumer_VIN()%></td>
						<td><%=a.getNumerNadwozia()%></td>
						<td><%=a.getNumerSilnika()%></td>
						<td><%=a.getRocznik()%></td>
						<td><%=a.getKolor()%></td>
						<td><%=a.getMoc_silnika_KM()%></td>
						<td><%=a.getNapedNaKola()%></td>
						<td><%=a.getLiczbaMiejsc()%></td>
						<td><%=a.getLiczbaDrzwi()%></td>
						<td><%=a.getPojemnoscBagaznikaWLitrach()%></td>
						<td><%=a.getZuzyciePaliwaNa100Km()%></td>
					</tr>
					</table>
        </div>
        <ul>
			<li>
					<a href="autoAktualneWypozyczeniaAdmin.jsp">Aktualne Wypożyczenia</a>
					</li>
					<li>
					<a href="autoHistoriaWypozyczenAdmin.jsp">Historia Wypozyczeń</a>
					</li>
					</ul>
        <div id="footer">
            footer
        </div>
</body>
</html>