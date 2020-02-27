<%@ page import="p.lodz.pl.encje.Auta" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl" %>
<%@ page import="p.lodz.pl.encje.AktualneWypozyczenie"%>
<%@ page import="p.lodz.pl.dao.AktualneDaoImpl"%>
<%@ page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    width:1900px;
}

#main { background: #eee }

#header {
    height: 45px;    
    background: #666;
    width:1900px;
}

#footer {
    height: 45px;
    clear: left;
    width:1900px;
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
	padding: 10px 162px;
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
          <h5 style="line-height: 31px">
				Samochody dostępne w wypożyczalnii
			</h5>
        <div class="spacer2"></div>
       
<% AutoDaoImpl Ado =new AutoDaoImpl();
List<Auta> lista=Ado.findAll();

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
						<td>Wiecej</td>
						<td>Rezerwacja</td>
						<td>Usuń</td>
					</tr>
					<%for(Auta a:lista){
					%>
					
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
					<td><a class="more"
							href="AutoInfo?idauto=<%=a.getIdauta()%>">Szczegóły</a></td>
					<td><a class="more"
							href="RezerwacjaAuta?idauto=<%=a.getIdauta()%>">Zarezerwuj</a></td>
				<td><a class="more"
							href="UsunAuto?idauto=<%=a.getIdauta()%>">Usuń</a></td>

					</tr>
					
					<%} %>
					
					</table>
					<div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="AutaPoDatach">
				<h1>Wyszukiwarka aut</h1>
				<p>Po datach</p>

				<label>Data Rezeracji format (yyyy-MM-dd) 
				</label> <input type="text" name="data1" id="data1" />
<label>Data Zwrotu format (yyyy-MM-dd) 
				</label> <input type="text" name="data2" id="data2" />
				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
		</div>
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
					<ul>
			<li>
					<a href="autopanel.jsp">Dodaj</a>
					</li>
					</ul>

        <div id="footer">
            footer
        </div>
</body>
</html>