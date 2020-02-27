<%@ page import="p.lodz.pl.encje.HistoriaWypozyczenia" %>
<%@ page import="p.lodz.pl.dao.HistoriaDaoImpl" %>
<%@ page import="java.util.List"%>
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
    width: 2000px;
}

#footer {
    height: 45px;
    clear: left;
     background: #666;
    width: 2000px;
}

#content {
    height: 700px;
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

DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
Integer idhistoria_wypozyczenia=(Integer) session.getAttribute("idhistoria_wypozyczenia");
HistoriaDaoImpl hdi=new HistoriaDaoImpl();
HistoriaWypozyczenia hw=hdi.findById(idhistoria_wypozyczenia);
HttpSession sess = request.getSession();
sess.setAttribute("historia_wypozyczenia", hw);
%>        
<div id="templatemo_main">
			<h2>Formularz Modyfikacji Wypożyczenia</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="modifyForm" method="post" onsubmit="return validateForm()" action="HistoriaEdit">
						 <h1>Modyfikacja</h1>
						 <p>Zmień Dane</p>
						 <label>Numer Identyfikacyjny
						
							 </label>
						 <input type="text"value="<%=hw.getIdhistoriaWypozyczenia()%>" name="idhistoria_wypozyczenia" id="idhistoria_wypozyczenia" />
						 <label>Numer Identyfikacyjny Klienta
				
							 </label>
						 <input type="text"value="<%=hw.getKlientid()%>" disable="disable" name="klientid" id="klientid" />
						 <label>Numer Identyfikacyjny Auta
					
							 </label>
						 <input type="text"value="<%=hw.getAutoId()%>" disable="disable"  name="autoid" id="autoid" />
						 <label>Marka Auta
							 </label>
						 <input type="text"value="<%=hw.getMarka()%>" disable="disable"  name="marka" id="marka" />
						  <label>Model Auta
							 </label>
						 <input type="text"value="<%=hw.getModel()%>" disable="disable"  name="model" id="model" />
						  <label>Imie Klienta
							 </label>
						 <input type="text"value="<%=hw.getImie()%>" disable="disable"  name="imie" id="imie" />
						  <label>Nazwisko Klienta
							 </label>
						 <input type="text"value="<%=hw.getNazwisko()%>" disable="disable"   name="nazwisko" id="nazwisko" />
						  <label>Data Rezerwacji format (yyyy-MM-dd)
							 </label>
						 <input type="text"value="<%=df.format(hw.getTerminWypozyczenia())%>" disable="disable"   name="terminWypozyczenia" id="terminWypozyczenia" />
						 <label>Data Zwrotu format (yyyy-MM-dd)*
							 </label>
						 <input type="text" value="<%=df.format(hw.getTerminOddania())%>"  name="terminOddania" id="terminOddania" />
						  <label>Liczba Dni*
							 </label>
						 <input type="text" value="<%=hw.getLiczbaDni()%>"  name="liczbaDni" id="liczbaDni" />
						 <label>Cena Za Segment
							 </label>
						 <input type="text" value="<%=hw.getCenaSegment()%>" disable="disable" name="cenaSegment" id="cenaSegment" />
						 <label>Cena Za Wyposazenie
							 </label>
						 <input type="text" value="<%=hw.getCenaDodatek()%>"disable="disable"  name="cenaDodatek" id="cenaDodatek" />
						 <label>Cena Za Całość
							 </label>
						 <input type="text" value="<%=hw.getStawkaSegmentWyposazenie()%>" disable="disable" name="stawkaSegmentWyposazenie" id="stawkaSegmentWyposazenie" />
						 <label>Status Zaliczki*
			</label> <select name="zaliczka">
				<option value="<%=hw.getStatusZaliczka()%>"><%=hw.getStatusZaliczka()%></option>
				<option value="Niezaplacona">Niezaplacona</option>
				<option value="Zaplacona">Zaplacona</option>
			</select>
			 <label>Dodatkowe Koszty
							 </label>
						 <input type="text" value="<%=hw.getDodatkowyKoszt()%>"  name="dodatkowyKoszt" id="dodatkowyKoszt" />
			<label>Przejechane Kilometry
							 </label>
						 <input type="text" value="<%=hw.getKilometry()%>"  name="kilometry" id="kilometry" />
				<label>Uwagi
							 </label>
						 <input type="text" value="<%=hw.getUwagi()%>"  name="uwagi" id="uwagi"  height=400/>
						 			 			 
			
						 <div class="spacer2"></div>
						 <label>* - pola do modyfikacji</label>
						 <button type="submit">Zmień Dane</button>
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