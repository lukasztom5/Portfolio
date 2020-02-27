<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Hurtownia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
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
<body id="home">
    <div id="main">
        <div id="header">
         	<ul>	
			<li>
				<a href="czesciprac.jsp">Części AGD</a>
			</li>	
			<li>
				<a href="rozliczeniaprac.jsp">Twoje Rozliczenia</a>
			</li>
			<li>
				<a href="praca.jsp">Twoja Praca</a>
			</li>	
			<li>
				<a href="contactprac.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li>  
		</ul>   
       <div class="spacer2"></div>
<% Integer idzakup = (Integer) session.getAttribute("idzakup");
Pracownik admin = (Pracownik) session.getAttribute("pracownik");
Integer idklient = (Integer) session.getAttribute("idklient");
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
%>
<div class="spacer2"></div>

        <div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="KoszykSzczegoly">
						 		
					 <label>Kod Zakup
						 </label>			 
						 <input type="text" value= <%=idzakup%> id="idzakup" name="idzakup" />
						 <h1>Panel szczegółów zamówienia</h1>
						 <p>Wprowadź dane</p>

						 <label>Data Dostarczenia Format (yyyy-MM-dd)*		
						 </label>	 				 
						 <input type="text" value= <%=df.format(dateobj).toString()%> id="data_dostarczenia" name="data_dostarczenia" />
                         <div class="spacer2"></div>
						
						 <label>Rodzaj Płatności*
							 </label>
						 						  <select id="rodzaj" name="rodzaj">
  <option  disabled selected>Wybierz Rodzaj Płatności</option>
  <option>Platnosc Zakladu</option>
  <option>Przelew</option>
  <option>Gotowka</option>
   <option>Karta Kredytowa</option> 
</select>
 <label>Czy Zapłacono*
</label>
 <select id="zaplata" name="zaplata">
  <option  disabled selected>Wybierz Czy Zapłacono</option>
  <option>Zaplacono</option>
  <option>Nie Zaplacono</option>
</select>
						 
						 <label>* - pola wymagane</label>
						 <button type="submit">Zatwierdź</button>
						 <div class="spacer"></div>
			
					 </form>
	 			</div>
			</div>


			
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
</body>
</html>