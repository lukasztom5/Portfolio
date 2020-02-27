<%@ page import="encje.*"%>
<%@ page import="dao.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
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
<script type="text/javascript">
	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}

function validateForm() {
	var x=document.forms["form2"]["imie"].value;
	var x2=document.forms["form2"]["nazwisko"].value;
	var x3=document.forms["form2"]["kraj"].value;
	var x4=document.forms["form2"]["miasto"].value;
	var x5=document.forms["form2"]["adres"].value;
	var x6=document.forms["form2"]["adres_mail"].value;
	var x7=document.forms["form2"]["telefon"].value;
	var x8=document.forms["form2"]["telefon_sluzbowy"].value;
	var x9=document.forms["form2"]["numer_konta"].value;
	var x10=document.forms["form2"]["pensja"].value;
	var x11=document.forms["form2"]["data_zatrudnienia"].value;
	var x12=document.forms["form2"]["data_zakonczenia"].value;
	var x13=document.forms["form2"]["login"].value;
	var x14=document.forms["form2"]["haslo"].value;
	
	if (x== null || x == "") {
  		alert("Podaj imie pracownika");
  		return false;
  	}else if (x2 == null || x2 == "") {
  		alert("Podaj nazwisko pracownika");
  		return false;
  	}else if (x3 == null || x3 == "") {
  		alert("Podaj kraj pochodzenie pracownika");
  		return false;
  	}else if (x4 == null || x4 == "") {
  		alert("Podaj miasto pracownika");
  		return false;
  	}else if (x5 == null || x5 == "") {
  		alert("Podaj adres zamieszkania pracownika");
  		return false;
  	}else if (x6 == null || x6 == "") {
  		alert("Podaj adres mail pracownika");
  		return false;
  	}else if (x7 == null || x7 == "") {
  		alert("Podaj numer prywatny telefonu pracownika");
  		return false;
  	}else
  	if (x8 == null || x8 == "") {
  		alert("Podaj numer służbowy telefonu pracownika");
  		return false;
  	}else
  	if (x9 == null || x9 == "" || x8.length()!=26) {
  		alert("Podaj numer konta pracownika");
  		return false;
  	}else
  	if (x10 == null || x10 == "") {
  		alert("Podaj pensję pracownika");
  		return false;
  	}else
  	if (x11 == null || x11 == "") {
  		alert("Podaj datę zatrudnienia");
  		return false;
  	}else
  	if (x12 == null || x12 == "") {
  		alert("Podaj data zakończenia pracy");
  		return false;
  	}else
  	
  	if (x13 == null || x13 == "") {
  		alert("Podaj swój login");
  		return false;
  	}else if (x14 == null || x14 == ""||x14.length()<8) {
  		alert("Podaj swoje hasło (min. 8 znaków)");
  		return false;
  	}
}
</script>
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
        <% DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Administrator admin = (Administrator) session.getAttribute("admin");
        AdministratorDaoImpl addi=new  AdministratorDaoImpl();
		Administrator ad=addi.findById(admin.getIDADMINISTRATOR());
		
%>
         </div>
         <br>
       <div id="templatemo_main">
			<h2>Formularz zatrudniania pracownika</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="ZatrudnijPracownika">
						  <label>Administrator*
							 </label>
						 <input type="text" value=<%=ad.getIDADMINISTRATOR()%> name="admin" id="admin" />
						 
						 <h1>Panel Zatrudniania</h1>
						 <p>Wprowadź dane pracownika</p>
						 
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
						 <label>Adres*
							  </label>
						 <input type="text" name="adres" id="adres" />
						 <label>Adres Mail*
							 </label>
						 <input type="text" name="adres_mail" id="adres_mail" />
					
						 <label>Telefon*
							</label> 
						 <input type="text" name="telefon" id="telefon" />
						 <label>Telefon Służbowy*
							</label> 
						 <input type="text" name="telefon_sluzbowy" id="telefon_sluzbowy" />
						  <label>Numer Konta Bankowego*
							</label> 
						 <input type="text" name="numer_konta" id="numer_konta" />
						   <label>Zarobki*
							</label> 
						 <input type="text" name="pensja" id="pensja" />
						 <label>Data Zatrudnienia*
							</label> 
						 <input type="text" value=<%=dateFormat.format(date).toString()%> name="data_zatrudnienia" id="data_zatrudnienia" />
						 <label>Data Zakończenia*
							</label> 
													 <input type="text" value=<%=dateFormat.format(date).toString()%> name="data_zakonczenia" id="data_zakonczenia" />
													 
						 <label>Login*
							</label> 
						 <input type="text" name="login" id="login" />
						 <label>Hasło (min. 8 znaków)*
							  </label>
						 <input type="text" name="haslo" id="haslo" />
 <div class="spacer2"></div>
						 <label>* - pola wymagane</label>
						 <button type="submit">Zapisz</button>
						 <div class="spacer"></div>
			
					 </form>
	 			</div>
			</div>
</div>
			</div>
			<div class="cleaner"></div>
		</div>
         <div id="footer">
        </div>
</body>
</html>