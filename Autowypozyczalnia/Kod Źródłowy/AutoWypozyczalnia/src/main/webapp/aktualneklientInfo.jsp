<%@page import="java.util.List"%>
<%@page import="java.lang.*"%>
<%@ page import="p.lodz.pl.encje.AktualneWypozyczenie" %>
<%@ page import="p.lodz.pl.encje.HistoriaWypozyczenia" %>
<%@ page import="p.lodz.pl.encje.Klient" %>
<%@ page import="p.lodz.pl.dao.HistoriaDaoImpl" %>
<%@ page import="p.lodz.pl.dao.AktualneDaoImpl" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl"%>
<%@ page import="p.lodz.pl.dao.WyposazenieDaoImpl"%>
<%@ page import="p.lodz.pl.encje.Wyposazenie"%>
<%@ page import="p.lodz.pl.encje.Auta"%>
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
    margin: 20px auto;
}

#main { background: #eee }

#header {
    height: 45px;    
    background: #aaa;
}

#footer {
    height: 45px;
    clear: left;
    background: #aaa;
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
	padding: 10px 20px;
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
Integer idaktualne_wypozyczenie=(Integer) session.getAttribute("idaktualne_wypozyczenie");
AktualneDaoImpl adi=new AktualneDaoImpl();
AktualneWypozyczenie aw=adi.findById(idaktualne_wypozyczenie);

HistoriaDaoImpl hdi=new HistoriaDaoImpl();
HistoriaWypozyczenia h=hdi.findById(aw.getIdaktualneWypozyczenie());


AutoDaoImpl ado =new AutoDaoImpl();
Auta a=ado.findAutaByModelMarka(h.getMarka().toString(), h.getModel().toString());
Double i=new Double(h.getCenaDodatek());
WyposazenieDaoImpl wdi= new WyposazenieDaoImpl();

Wyposazenie w=wdi.findByCena(i.intValue());


%>
<div class="CSSTableGenerator">
<table>
					<tr>
						<td>Marka Auta</td>
						<td>Model Auta</td>
						<td>Segment</td>
						<td>Imie Klienta</td>
						<td>Nazwisko Klienta</td>
						<td>Termin Wypożyczenia</td>
						<td>Data Wypożyczenia</td>
						<td>Termin Oddania</td>
						<td>Data Oddania</td>
						<td>Liczba Dni</td>
						<td>Cena Segment</td>
						<td>Cena Dodatek</td>
						<td>Dodatek</td>
						<td>Całkowita Cena</td>
					</tr>
					
					<tr>
						<td><%=h.getMarka()%></td>
						<td><%=h.getModel()%></td>
						<td><%=a.getSegment()%></td>
						<td><%=h.getImie()%></td>
						<td><%=h.getNazwisko()%></td>
						<td><%=h.getTerminWypozyczenia()%></td>
						<td><%=h.getDzienWypozyczenia()%></td>
						<td><%=h.getTerminOddania()%></td>
						<td><%=h.getDzienOddania()%></td>
						<td><%=h.getLiczbaDni()%></td>
						<td><%=h.getCenaSegment()+" zł"%></td>
						<td><%=h.getCenaDodatek()+" zł"%></td>
						<td><%=w.getDodatek()%></td>
						<td><%=h.getStawkaSegmentWyposazenie()+" zł"%></td></tr>
					
					
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