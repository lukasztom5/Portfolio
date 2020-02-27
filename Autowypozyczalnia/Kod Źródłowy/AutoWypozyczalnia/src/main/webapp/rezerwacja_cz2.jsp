<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="p.lodz.pl.encje.HistoriaWypozyczenia" %>
<%@ page import="p.lodz.pl.encje.Wyposazenie" %>
<%@ page import="p.lodz.pl.dao.HistoriaDaoImpl" %>
<%@ page import="p.lodz.pl.dao.WyposazenieDaoImpl" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


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
    width: 2000px;  
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    width: 2000px;
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
	padding: 10px 175px;
	border-right: 1px solid #fff;
	border-right: 1px solid #fff;
}

ul a:hover {
	background-color: #800;
	background-image: url("tlo2.gif");
}
</style>
<script type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>
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
<%
String idaktualne = (String) session.getAttribute("idhistoria_wypozyczenia");
int w=Integer.parseInt(idaktualne);
HistoriaDaoImpl hdi=new HistoriaDaoImpl();
HistoriaWypozyczenia h=hdi.findById(w);


String sampleString = h.getWyposazenie().toString();
String[] items = sampleString.split(",");
List<String> itemList = new ArrayList<String>();

for (String item : items) {
    itemList.add(item);
 }
%>
       <div id="contact_form">


				<div id="templatemo_main">
				<div class="col_w630">
			<div id="mystyle4" class="myform4">
				<form id="form"  method="post" action="AnulujRezerwacja">
					
			<h5 align="center">Rezerwacja zakończona sukcesem</h5>
			<h2>Liczba Dni <%= h.getLiczbaDni() %><br/><br/>
				Dzienna cena za segment: <%=  h.getCenaSegment()+ " zł"  %><br/>
				Całkowita cena za segment: <%= h.getCenaSegment()*h.getLiczbaDni()+ " zł"  %><br/><br/>
				Dzienna cena Za wyposażenie: <%=  h.getCenaDodatek()+" zł"  %><br/>
				Całkowita cena Za wyposażenie: <%=  h.getCenaDodatek()*h.getLiczbaDni()+" zł"  %><br/><br/>
				Wyposażenie:<br/>
				<%for(int i=0; i<itemList.size(); i++) {%>
					<%= itemList.get(i).trim()%>
				<br/>
				<%} %>
				Cena całkowita <%= h.getStawkaSegmentWyposazenie()+ " zł" %><br/></h2>
			<div class="col_w630">
			<h5 align="center">
					Aby anulować rezerwację kliknij przycisk Anuluj
				</h5>
			<button type="submit" name="cancel" style="float: center;">Anuluj</button><div class="spacer2"></div>
					<div class="spacer"></div>
		
				</form>
			</div>
			</div>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>