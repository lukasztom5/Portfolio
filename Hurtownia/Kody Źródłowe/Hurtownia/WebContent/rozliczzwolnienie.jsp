<%@ page import="encje.*" %>
<%@ page import="dao.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
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
	padding: 10px 102px;
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
		</div></div>
        <div class="spacer2"></div>
       
<% 
Integer idpracownik = (Integer) session.getAttribute("idpracownik");
PracownikDaoImpl pdi =new PracownikDaoImpl();
Pracownik p=pdi.findById(idpracownik);
PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
HttpSession sess = request.getSession();
sess.setAttribute("PRACOWNIK", p);
%>
 
  <div id="templatemo_main">
			<h2>Podsumowanie Zwolnienia</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="DodajRozliczZwol">
						 <h1>Podsumowanie Zatrudnienia</h1>
						 <p>Zmień Dane</p>
						  <label>Numer Identyfikacyjny Pracownika
						
							 </label>
						 <input type="text" value="<%=p.getIDPRACOWNIK()%>" name="idpracownik" id="idpracownik" />
							 <label>Numer Identyfikacyjny Administratora
							 </label>
						 <input type="text" value="<%=p.getIDADMINISTRATOR().getIDADMINISTRATOR()%>" name="admin" id="admin" />
							 
						 <label>Imie*
							 </label>
						 <input type="text" value="<%=pd.getImie()%>" name="imie" id="imie" />
						 <label>Nazwisko*
						 </label>	 
						 <input type="text" value="<%=pd.getNazwisko()%>" name="nazwisko" id="nazwisko" />
						
						<label>Data Zatrudnienia*
							</label> 
						 <input type="text" value="<%=pd.getDataZakonczenia()%>" name="data_zakonczenia" id="data_zakonczenia" />
	<label>Przyczyna Zwolnienia*
							</label> 					 
<select id="rodzaj" name="rodzaj">
  <option  disabled selected>Wybierz Przyczynę Zwolnienia</option>
  <option>Koniec Praktyk</option>
    <option>Zwolnienie w Trybie Natychmiastowym</option>
  <option>Zwolnienie Dyscyplinarne</option>
  <option>Zwolnienie Za Ugodą Stron</option>
   <option>Emerytura</option> 
</select>
 <div class="spacer2"></div>
						 <label>* - pola do zmiany</label>
						 <button type="submit">Rozlicz</button>
						 
						 <div class="spacer"></div>
					 </form>
					 
	 			</div>
			</div>
</div>
        <div id="footer">
            footer
        </div>
</body>
</html>