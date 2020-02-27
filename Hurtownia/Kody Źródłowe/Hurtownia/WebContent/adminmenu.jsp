<%@ page import="encje.Administrator"%>
<%@ page import="dao.AdminDaneDaoImpl"%>
<%@ page import="encje.AdminDane"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Hurtownia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
}

#main { background: #eee ;width: 1323px;}

#header {
	height: 45px;
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    width: 1323px;
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
	text-align: center; 
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
	padding: 10px 95px;
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
				<a href="czesci.jsp">Części AGD</a>
			</li>	
			<li>
				<a href="client.jsp">Klienci</a>
			</li>
			<li>
				<a href="pracownicy.jsp">Pracownicy</a>
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

		<div id="content">
<%
			String tekst = "Witaj na stronie administratorze:";
			Administrator admin = (Administrator) session.getAttribute("admin");
			
			if (admin != null) {
				AdminDaneDaoImpl addi=new AdminDaneDaoImpl();
				AdminDane ad=addi.findByIdAdmin(admin.getIDADMINISTRATOR());
				tekst = tekst+" "+ad.getImie()
						+ " " + ad.getNazwisko() + "</b>";
						
			} else {
				tekst= "Nie jestes zalogowany";
			}
		%>
		<p style="color: black; margin-bottom: 0px; text-align: center;">
			<h1><%=tekst%></h1>
		</p>
        </div>
        </div>
        <div id="footer">
            
        </div>
    </div>
</body>
</html>