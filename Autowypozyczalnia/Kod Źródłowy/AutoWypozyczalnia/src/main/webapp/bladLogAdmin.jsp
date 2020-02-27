<%@ page import="p.lodz.pl.encje.Administrator"%>
<%@ page import="p.lodz.pl.wypozyczalnia.kontroler.AdminLogin"%>
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
	padding: 10px 170px;
	border-right: 1px solid #fff;
	border-right: 1px solid #fff;
}

ul a:hover {
	background-color: #800;
	background-image: url("tlo2.gif");
}
</style>
<script>
function validateForm() {
	var x=document.forms["form"]["password"].value;
	var x2=document.forms["form"]["login"].value;
		var x3=document.forms["form"]["idadministrator"].value;
		if (x3 == null || x3 == "") {
	  		alert("Podaj numer identyfikcyjny");
	  		return false;
		}
		if (x2 == null || x2 == "") {
	  		alert("Podaj login");
	  		return false;
	  	} if (x == null || x == "") {
	  		alert("Podaj Haslo");
	  		return false;
	  	}
	}
</script>
</head>

<body>
        <div id="header">
         	<ul>
			<li>
				<a href="cennik.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalog.jsp">Katalog</a>
			</li>
			<li>
				<a href="login.jsp">Logowanie</a>
			</li>	
			<li>
				<a href="registry.jsp">Rejestracja</a>
			</li>	
			<li>
				<a href="contact.jsp">Kontakt</a>
			</li>
		</ul>   
            
        </div>
        <center>
				<div id="templatemo_main">
			<h2 align="center">Zły Numer Id, Login Lub Hasło</h2>
			<div class="col_w630">
				<h5 align="center">
					Aby spróbować ponownie, <a href="admin.jsp">kliknij tutaj</a>
				</h5>
			</div></div>
         </center>
        <div id="footer">
            footer
        </div>
</body>
</html>