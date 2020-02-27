<%@ page import="p.lodz.pl.encje.Klient"%>
<%@ page import="p.lodz.pl.encje.Auta"%>
<%@ page import="p.lodz.pl.encje.Segment"%>
<%@ page import="p.lodz.pl.encje.Wyposazenie"%>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl"%>
<%@ page import="p.lodz.pl.dao.KlientDaoImpl"%>
<%@ page import="p.lodz.pl.dao.SegmentDaoImpl"%>
<%@ page import="p.lodz.pl.dao.WyposazenieDaoImpl"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
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
    width:2000px;
}

#footer {
    height: 45px;
    clear: left;
    background: #666;
    width:2000px;
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
	padding: 10px 172px;
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

							 <% 
Integer idauta = (Integer) session.getAttribute("idauto");
AutoDaoImpl Ado =new AutoDaoImpl();
Auta a=Ado.findById(idauta);


DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();

SegmentDaoImpl sdi=new SegmentDaoImpl();
Segment s=sdi.findSegment(a.getSegment());

WyposazenieDaoImpl wdi=new WyposazenieDaoImpl();
List<Wyposazenie> lista= wdi.findAll();

%>
<div id="templatemo_main">
			<h2>Formularz Rezerwacji Samochodu</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="AktualneRezerwacja">
						 <h1>Rezerwacja</h1>
						 <p>Wprowadz dane</p>
						 <label>Numer Identyfikacyjny Auta
							 </label>
			<input type="text" value= <%=a.getIdauta()%>  required="required" /> 
			<label>Proszę przepisać podany numer identyfikacyjny auta*
							 </label>
			<input type="text" id="idauta" name="idauta" required="required" /> <br><br><br><br>
						 <label>Marka Auta
							 </label>
			<input type="text" value= <%=a.getMarka()%> id="marka" name="marka" required="required" /> 	 
			             <label>Model Auta
							 </label>
						<input type="text" value= <%=a.getModel() %> id="model" name="model" required="required" /> 
						<label>Wpisać numer identyfikacyjny klienta*
						 </label>		
						 <input type="text"  id="idklient" name="idklient" required="required" /><br>
						 <label>Wpisz Imie Klienta*
						 </label>	
						 <input type="text"  id="imie" name="imie"required="required" />
						 <label>Wpisz Nazwisko Klienta*
						 </label>	
						 <input type="text"  id="nazwisko" name="nazwisko" required="required" />

						 <br><br><br><br><br><br><br><br>					 
						<label>Data Rezerwacji format (yyyy-MM-dd)	
						 </label>	 				 
						 <input type="text" value= <%=df.format(dateobj).toString()%> id="data_rezerwacja" name="data_rezerwacja" />
						 <label>Data Zwrotu Format (yyyy-MM-dd)*		
						 </label>	 				 
						 <input type="text" id="data_zwrotu" name="data_zwrotu" />
						  <label>Liczba Dni*	
						 </label>	 				 
						 <input type="text" id="liczba_dni" name="liczba_dni" />
						
						 <label>Segment	
						 </label>	 				 
						 <input type="text" value= <%=a.getSegment() %> id="segment" name="segment"/>

			             <label>
				            Zaliczka
			             </label>
						 <select name="zaliczka">
				         <option value="nie">Niezaplacona</option>
				         <option value="tak">Zaplacona</option>
			             </select>
						 
						 <h1><p>Dodatkowe Wyposażenie</p></h1>
						 <label>
				             Nawigacja GPS
			             </label>
						 <select name="dodatek1">
				         <option value="no">Nie Wybrano</option>
				         <option value="add1">Wybierz</option>
			             </select>
			             <label>
				            Fotelik Dziecięcy
			             </label>
						 <select name="dodatek2">
				         <option value="no">Nie Wybrano</option>
				         <option value="add2">Wybierz</option>
			             </select>
			             <label>
				             Bagażnik Dachowy
			             </label>
						 <select name="dodatek3">
				         <option value="no">Nie Wybrano</option>
				         <option value="add3">Wybierz</option>
			             </select>
			              <label>
				             Łańcuchy na Koła
			             </label>
						 <select name="dodatek4">
				         <option value="no">Nie Wybrano</option>
				         <option value="add4">Wybierz</option>
			             </select>
			              <label>
				             Bagażnik Rowerowy
			             </label>
						 <select name="dodatek5">
				         <option value="no">Nie Wybrano</option>
				         <option value="add5">Wybierz</option>
			             </select>
			              <label>
				             Zimowe Opony
			             </label>
						 <select name="dodatek6">
				         <option value="no">Nie Wybrano</option>
				         <option value="add6">Wybierz</option>
			             </select>
			             <label>* - pole do wypełnienia</label>
						 <button type="submit">Wypożycz</button>
						 <div class="spacer"></div>
					 </form>
	 			</div>

        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>