<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="p.lodz.pl.encje.Wyposazenie"%>
<%@page import="p.lodz.pl.encje.Segment"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
	padding: 10px 107px;
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
<form action="cennik"></form>
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
        <div id="content">
        <h5 style="line-height: 31px">
				Cennik za segment
			</h5>
<div class="CSSTableGenerator">
					<table>
						<tr>
							<td>Segment</td>
							<td>Cena za dobę</td>
						</tr>
						<tr>
							<td>A</td>
							<td>70 zł</td>
						</tr>
						<tr>
							<td>B</td>
							<td>80 zł</td>
						</tr>
						<tr>
							<td>C</td>
							<td>120 zł</td>
						</tr>
						<tr>
							<td>D</td>
							<td>180 zł</td>
						</tr>
						<tr>
							<td>E</td>
							<td>200 zł</td>
						</tr>
						<tr>
							<td>F</td>
							<td>250 zł</td>
						</tr>
						<tr>
							<td>G</td>
							<td>500 zł</td>
						</tr>
						<tr>
							<td>Kabriolet</td>
							<td>200 zł</td>
						</tr>
						<tr>
							<td>SUV</td>
							<td>170 zł</td>
						</tr>
						<tr>
							<td>VAN</td>
							<td>170 zł</td>
						</tr>
						<tr>
							<td>R</td>
							<td>250 zł</td>
						</tr>
					</table>
				</div>	
        </div>
         <br><br><br><br>
        <h5 style="line-height: 31px">
				Cennik za dodatkowe wyposażenie do samochodu
			</h5>
                <div id="content">
<div class="CSSTableGenerator">
					<table>
						<tr>
							<td>Dodatkowe Wyposażenie</td>
							<td>Cena za dobę</td>
						</tr>
						<tr>
							<td>Nawigacja GPS</td>
							<td>30 zł</td>
						</tr>
						<tr>
							<td>Fotelik Dziecięcy</td>
							<td>10 zł</td>
						</tr>
						<tr>
							<td>Bagażnik Dachowy</td>
							<td>20 zł</td>
						</tr>
						<tr>
							<td>Lańcuchy na Koła</td>
							<td>6 zł</td>
						</tr>
						<tr>
							<td>Bagażnik Rowerowy</td>
							<td>15 zł</td>
						</tr>
						<tr>
							<td>Zimowe Opony</td>
							<td>20 zł</td>
						</tr>
					</table>
				</div>	
        </div>
         <div id="footer">
            Wypożyczalnia 2015
        </div>
    </div>
</body>
</html>