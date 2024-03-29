<%@ page contentType="text/html;charset=UTF-8"%>
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

#main { background: #eee ;width: 100%;}

#header {
	height: 45px;
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    width: 1315px;
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
	padding: 10px 133px;
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
	var x=document.forms["form2"]["imie"].value;
	var x2=document.forms["form2"]["nazwisko"].value;
	var x3=document.forms["form2"]["kraj"].value;
	var x4=document.forms["form2"]["miasto"].value;
	var x5=document.forms["form2"]["adres"].value;
	var x6=document.forms["form2"]["adres_mail"].value;
	var x7=document.forms["form2"]["telefon"].value;
	var x8=document.forms["form2"]["login"].value;
	var x9=document.forms["form2"]["haslo"].value;
	var x10=document.forms["form2"]["zaklad"].value;
	
	if (x== null || x == "") {
  		alert("Podaj swoje imie");
  		return false;
  	} else if (x2 == null || x2 == "") {
  		alert("Podaj swoje nazwisko");
  		return false;
  	}else  if (x3 == null || x3 == "") {
  		alert("Podaj swój kraj");
  		return false;
  	} else if (x4 == null || x4 == "") {
  		alert("Podaj miasto");
  		return false;
  	}else  if (x5 == null || x5 == "") {
  		alert("Podaj swój adres zameldowania");
  		return false;
  	}else  if (x6 == null || x6 == "") {
  		alert("Podaj swój adres mail");
  		return false;
  	}else  if (x7 == null || x7 == "") {
  		alert("Podaj swój numer telefonu");
  		return false;
  	}else  if (x8 == null || x8 == "") {
  		alert("Podaj swój login");
  		return false;
  	}else if (x9 == null || x9 == ""||x9.length()<8) {
  		alert("Podaj swoje hasło (min. 8 znaków)");
  		return false;
  	}
  	else if (x10 == null || x10 == "") {
		alert("Podaj nazwę zakładu lub wpisz brak");
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
				<a href="catalog.jsp">Katalog</a>
			</li>
			<li>
				<a href="login.jsp">Logowanie</a>
			</li>
			<li>
				<a href="Registry.jsp">Rejestracja</a>
			</li>	
			<li>
				<a href="contact.jsp">Kontakt</a>
			</li>
		</ul>
         <br style="clear: left" />   
        
			</div>

        <div id="templatemo_main">
			<h2>Formularz rejestracyjny</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="KlientRejestracja">
						 <h1>Panel Rejestracji</h1>
						 <p>Wprowadź dane</p>
						 
						 <label>Imie*
							 </label>
						 <input type="text" name="imie" id="imie" />
						 <label>Nazwisko*
						 </label>	 
						 <input type="text" name="nazwisko" id="nazwisko" />
						
						<label>Kraj*
							 </label>
						 <input type="text" name="kraj" id="kraj" />
						
						 <label>Miasto*
							 </label>
						 <input type="text" name="miasto" id="miasto" />
						 <label>Nazwa zakładu*
							  </label>
						 <input type="text" name="zaklad" id="zaklad" />
						 <label>Adres*
							  </label>
						 <input type="text" name="adres" id="adres" />
						 <label>Adres Mail*
							 </label>
						 <input type="text" name="adres_mail" id="adres_mail" />
					
						 <label>Telefon*
							</label> 
						 <input type="text" name="telefon" id="telefon" />
						 <label>Login*
							</label> 
						 <input type="text" name="login" id="login" />
						 <label>Hasło (min. 8 znaków)*
							  </label>
						 <input type="text" name="haslo" id="haslo" />
                         <div class="spacer2"></div>
						 <label>* - pola wymagane</label>
						 <button type="submit">Zarejestruj</button>
						 <div class="spacer"></div>
			
					 </form>
	 			</div>
			</div>
</div>
			</div>
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>