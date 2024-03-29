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
				Szczegóły Wypożyczenia
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
						<td>Termin Wypożyczenia</td>
						<td>Termin Oddania</td>
						<td>Liczba Dni</td>
						<td>Cena Segment</td>
						<td>Cena Dodatek</td>
						<td>Całkowita Cena</td>
						<td>Wyposazenie</td>
						<td>Status Zaliczki</td>
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
						<td><%=h.getTerminWypozyczenia()%></td>
						<td><%=h.getTerminOddania()%></td>
						<td><%=h.getLiczbaDni()%></td>
						<td><%=h.getCenaSegment()+" zł"%></td>
						<td><%=h.getCenaDodatek()+" zł"%></td>
						<td><%=h.getWyposazenie()%></td>
						<td><%=h.getStawkaSegmentWyposazenie()+" zł"%></td>
						<td><%=h.getStatusZaliczka()%></td>
						</tr>
					
					
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