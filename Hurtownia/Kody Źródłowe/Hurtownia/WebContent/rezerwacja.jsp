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
	padding: 10px 93px;
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
<% Integer idcz = (Integer) session.getAttribute("idczesc");
KlientDaoImpl kdi =new KlientDaoImpl();
List<Klient> lista=kdi.findAll();
CzescDaoImpl cdi = new CzescDaoImpl();
Czesc c=cdi.findById(idcz);
Pracownik admin = (Pracownik) session.getAttribute("pracownik");
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
CzescWidok kd4=kdi2.findByIdczesc(c.getIDCZESC());
%>
<div class="spacer2"></div>

        <div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="Rezerwuj">
						 <h1>Panel rezerwacji czesci</h1>
						 <p>Wprowadź dane</p>
						 <label>Id pracownik*
							 </label>
						 <input type="text"  value="<%=admin.getIDPRACOWNIK()%>" name="idpracownik" id="idpracownik" />
						 <label>Klient
							 </label>
						 <select id="idklient" name="idklient">
  <option  disabled selected>Wybierz Klienta</option>
  <%for(Klient k:lista){
  
  KlientDaneDaoImpl mddi1=new KlientDaneDaoImpl();
  KlientDane kdd = mddi1.findByIdklient(k.getIDKLIENT());

					%>
  <option><%=kdd.getKod()%></option>
  <%} %>
</select>
						  <label>Id czesc*
							 </label>
						 <input type="text"  value="<%=c.getIDCZESC()%>" name="idczesc" id="idczesc" />
						 <label>Data Zamówienia format (yyyy-MM-dd)	
						 </label>	 				 
						 <input type="text" value= <%=df.format(dateobj).toString()%> id="data_zamowienia" name="data_zamowienia" />
						 <label>Data Dostarczenia Format (yyyy-MM-dd)*		
						 </label>	 				 
						 <input type="text" value= <%=df.format(dateobj).toString()%> id="data_dostarczenia" name="data_dostarczenia" />
                         <div class="spacer2"></div>
                           <label>Cena czesci
							 </label>
						 <input type="text"  value="<%=kd4.getCena()%>" name="cena" id="cena" />
						   <label>Liczba Sztuk*
							 </label>
						 <input type="text"  value="<%=kd4.getIlosc()%>" name="sztuki" id="sztuki" />
						
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
						 <button type="submit">Zarezerwuj</button>
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