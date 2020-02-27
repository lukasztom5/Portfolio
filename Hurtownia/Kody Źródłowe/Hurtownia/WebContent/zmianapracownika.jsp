<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
            
        </div>
         </div>
        <div class="spacer2"></div>
<% PracownikDaoImpl pdi =new PracownikDaoImpl();
List<Pracownik> lista=pdi.findAll();
Administrator admin = (Administrator) session.getAttribute("admin");

Integer idakt= (Integer) session.getAttribute("idaktualne_zamowienie");
AktualneDaoImpl pdi2 =new AktualneDaoImpl();
AktualneZamowienia a=pdi2.findById(idakt);

PracownikDaoImpl pii = new PracownikDaoImpl();
Pracownik pp = pii.findById(a.getIDPRACOWNIK().getIDPRACOWNIK());

PracDaneDaoImpl poo = new PracDaneDaoImpl();
PracDane pioi = poo.findByIdprac(pp.getIDPRACOWNIK());

List<Pracownik> lista1 = pii.findwithoutid(a.getIDPRACOWNIK().getIDPRACOWNIK());
%>

 <div id="templatemo_main">
			<h2>Przekazanie Realizacji Zadania<br><br> Innemu Pracownikowi</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="PrzekazInnemu">
						 <h1>Modyfikacja</h1>
						 <p>Zmień Dane</p>
						<label>Numer Zamówienia
							 </label>
						 <input type="text" value="<%=a.getIDAKTUALNEZAMOWIENIE()%>" name="idaktualne_zamowienie" id="idaktualne_zamowienie" />
						<label>Pracownik Posiadający Zlecenie
							 </label>
						 <input type="text" value="<%=pioi.getKod()%>" name="idprac1" id="idprac1" /> 
							 
							  <label>Pracownik Do Przekazania Zlecenia*
						 </label>
						 <select id="idprac2" name="idprac2">
  <option  disabled selected>Wybierz Pracownika</option>
  <%for(Pracownik k:lista1){
  
  PracDaneDaoImpl mddi1=new PracDaneDaoImpl();
  PracDane kdd = mddi1.findByIdprac(k.getIDPRACOWNIK());

					%>
  <option><%=kdd.getKod()%></option>
  <%} %>
</select>

						
						 <label>* - pola możliwe do zmiany</label>
						 <button type="submit">Przekaż Innemu</button>
						 
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