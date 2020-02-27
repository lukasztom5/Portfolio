<%@ page import="p.lodz.pl.encje.Auta" %>
<%@ page import="p.lodz.pl.dao.AutoDaoImpl" %>
<%@ page import="java.util.List"%>
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
    width: 2000px;
    background: #666;
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
	padding: 10px 170px;
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
<script>
	function validateForm() {
		var x=document.forms["form2"]["marka"].value;
		var x2=document.forms["form2"]["model"].value;
		var x3=document.forms["form2"]["segment"].value;
		var x4=document.forms["form2"]["paliwo"].value;
		var x5=document.forms["form2"]["skrzynia_biegow"].value;
		var x6=document.forms["form2"]["numer_rejestracyjny"].value;
		var x7=document.forms["form2"]["numer_VIN"].value;
		var x8=document.forms["form2"]["numer_nadwozia"].value;
		var x9=document.forms["form2"]["numer_silnika"].value;
		var x10=document.forms["form2"]["rocznik"].value;
		var x11=document.forms["form2"]["kolor"].value;
		var x12=document.forms["form2"]["moc_silnika_KM"].value;
		var x13=document.forms["form2"]["naped_na_kola"].value;
		var x14=document.forms["form2"]["liczba_miejsc"].value;
		var x15=document.forms["form2"]["liczba_drzwi"].value;
		var x16=document.forms["form2"]["pojemnosc_bagaznika_w_litrach"].value;
		var x17=document.forms["form2"]["zuzycie_paliwa_na_100_km"].value;
		
		if (x== null || x == "") {
	  		alert("Podaj nazwę marki");
	  		return false;
	  	} if (x2 == null || x2 == "") {
	  		alert("Podaj model auta");
	  		return false;
	  	} if (x3 == null || x3 == "") {
	  		alert("Podaj rodzaj segmentu");
	  		return false;
	  	} if (x4 == null || x4 == "") {
	  		alert("Podaj rodzaj paliwa");
	  		return false;
	  	} if (x5 == null || x5 == "") {
	  		alert("Podaj rodzaj skrzyni biegów");
	  		return false;
	  	} if (x6 == null || x6 == "") {
	  		alert("Podaj numer rejestracyjny");
	  		return false;
	  	} if (x7 == null || x7 == "") {
	  		alert("Podaj numer VIN");
	  		return false;
	  	} if (x8 == null || x8 == "") {
	  		alert("Podaj numer nadwozia");
	  		return false;
	  	}if (x9 == null || x9 == "") {
	  		alert("Podaj numer silnika");
	  		return false;
	  	}if (x10== null || x10 == "") {
	  		alert("Podaj rocznik");
	  		return false;
	  	} if (x11 == null || x11 == "") {
	  		alert("Podaj kolor nadwozia");
	  		return false;
	  	} if (x12 == null || x12 == "") {
	  		alert("Podaj moc silnika");
	  		return false;
	  	} if (x13 == null || x13 == "") {
	  		alert("Podaj rodzaj napędu na koła (Przednie Koła, Tylne Koła lub Na Cztery Koła)");
	  		return false;
	  	} if (x14 == null || x14 == "") {
	  		alert("Podaj liczbę miejsc");
	  		return false;
	  	} if (x15 == null || x15 == "") {
	  		alert("Podaj liczbę drzwi");
	  		return false;
	  	} if (x16 == null || x16 == "") {
	  		alert("Podaj pojemność bagażnika w litrach");
	  		return false;
	  	} if (x17 == null || x17 == "") {
	  		alert("Podaj zużycie paliwa na 100 km");
	  		return false;
	  		}
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
<div id="templatemo_main">
			<h2>Formularz Dodawania Samochodu</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="AutoRegistry">
						 <h1>Dodawanie Auta</h1>
						 <p>Wprowadz dane</p>
						 
						 <label>Marka*
							 </label>
						 <input type="text" name="marka" id="marka" />
						 <label>Model*
						 </label>	 
						 <input type="text" name="model" id="model" />
						 <label>Segment*
						 </label>	 				 
						 <input type="text" name="segment" id="segment" />
						
						 <label>Paliwo*
							 </label>
						 <input type="text" name="paliwo" id="paliwo" />
						 
						 <label>Skrzynia Biegów*
							  </label>
						 <input type="text" name="skrzynia_biegow" id="skrzynia_biegow" />
						 <label>Numer Rejestracyjny*
							 </label>
						 <input type="text" name="numer_rejestracyjny" id="numer_rejestracyjny" />
					
						 <label>Numer VIN*
							</label> 
						 <input type="text" name="numer_VIN" id="numer_VIN" />
						 <label>Numer Nadwozia*
							</label> 
						 <input type="text" name="numer_nadwozia" id="numer_nadwozia" />
						 <label>Numer Silnika*
							  </label>
						 <input type="text" name="numer_silnika" id="numer_silnika" />
						<label>Rocznik*
							  </label>
						 <input type="text" name="rocznik" id="rocznik" />
						 <label>Kolor*
							  </label>
						 <input type="text" name="kolor" id="kolor" />
						 <label>Moc Silnika w KM*
							  </label>
						 <input type="text" name="moc_silnika_KM" id="moc_silnika_KM" />
						 <label>Napęd Na Koła*
							  </label>
						 <input type="text" name="naped_na_kola" id="naped_na_kola" />
						 <label>Liczba Miejsc*
							  </label>
						 <input type="text" name="liczba_miejsc" id="liczba_miejsc" />
						 <label>Liczba Drzwi*
							  </label>
						 <input type="text" name="liczba_drzwi" id="liczba_drzwi" />
						 <label>Pojemność Bagażnika w Litrach*
							  </label>
						 <input type="text" name="pojemnosc_bagaznika_w_litrach" id="pojemnosc_bagaznika_w_litrach" />
						 <label>Zużycie Paliwa Na 100 km*
							  </label>
						 <input type="text" name="zuzycie_paliwa_na_100_km" id="zuzycie_paliwa_na_100_km" />
						 <div class="spacer2"></div>
						 <label>* - pola wymagane</label>
						 <button type="submit">Zarejestruj</button>
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