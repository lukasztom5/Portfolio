<%@ page import="p.lodz.pl.encje.Auta"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="p.lodz.pl.encje.AktualneWypozyczenie"%>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl"%>
<%@ page import="p.lodz.pl.dao.AktualneDaoImpl"%>
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
         </div>
         <h5 style="line-height: 31px">
				Aktualne wypożyczenia
			</h5>
        <div class="spacer2"></div>
       
<% 
Integer idauta = (Integer) session.getAttribute("idauto");
AktualneDaoImpl adi = new AktualneDaoImpl();
List<AktualneWypozyczenie> list = adi.findKlientByIdAuta(idauta);

DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
%>
 
<div class="CSSTableGenerator">
<table>
					<tr>
					    <td>Id Aktulne Wypozyczenie</td>
						<td>Id Auta</td>
						<td>Id Klienta</td>
						<td>Data Rezerwacji</td>
						<td>Data Zwrotu</td>
						<td>Więcej</td>
						<td>Modyfikacja</td>
						<td>Usuń</td>
					</tr>
					<%for(AktualneWypozyczenie aw: list){
					%>
					<tr>
					    <td><%=aw.getIdaktualneWypozyczenie() %></td>
					    <td><%=aw.getAutoId() %></td>
					    <td><%=aw.getKlientid() %></td>
					    <td><%=df.format(aw.getDataRezerwacja())%></td>
						<td><%=df.format(aw.getDataZwrotu())%></td>
					<td><a class="more"
							href="AktualneInfoAdmin?idaktualne_wypozyczenie=<%=aw.getIdaktualneWypozyczenie()%>">Szczegóły</a></td>
					<td><a class="more"
							href="AktualneModify?idaktualne_wypozyczenie=<%=aw.getIdaktualneWypozyczenie()%>">Modyfikuj</a></td>
					<td><a class="more"
							href="PanelUwagi?idaktualne_wypozyczenie=<%=aw.getIdaktualneWypozyczenie()%>">Usuń</a></td>
					
					</tr>
					<%} %>
					</table>
        </div>
        <ul>
					<li>
					<a href="autoHistoriaWypozyczenAdmin.jsp">Historia Wypozyczeń</a>
					</li>
					</ul>
        <div id="footer">
            footer
        </div>
</body>
</html>