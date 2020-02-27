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

         <div id="templatemo_main">
			<h2 align="center">Wyszukiwanie Pracownika</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="ZnajdzPracownika">
				<p>Po numerze identyfikacyjnym przełożonego</p>

				<label>Wpisz numer identyfikacyjny
				</label> <input type="text" name="ida" id="ida" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>
			</form>
<form id="form" name="form" method="post"
				action="ZnajdzPracownika">
				<p>Po nazwisko</p>

				<label>Wpisz nazwisko
				</label> <input type="text" name="nazwisko" id="nazwisko" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzPracownika">
				<p>Po imieniu</p>

				<label>Wpisz imie
				</label> <input type="text" name="imie" id="imie" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzPracownika">
				<p>Po kraju</p>

				<label>Wpisz kraj
				</label> <input type="text" name="kraj" id="kraj" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
			action="ZnajdzPracownika">
				<p>Po mieście</p>

				<label>Wpisz miasto
				</label> <input type="text" name="miasto" id="miasto" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
		</div>
			<div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="ZnajdzPracownikaPoZarobkach">
				<p>Po zarobkach</p>

				<label>Wpisz min. Zarobki
				</label> <input type="text" name="pensja1" id="pensja1" />
<label>Wpisz max. Zarobki
				</label> <input type="text" name="pensja2" id="pensja2" />
				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			
		</div>
			<div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="ZnajdzPracownikaPoDatach">
				<p>Po datach Zatrudnienia</p>

				<label>Wpisz Datę format (yyyy-MM-dd) 
				</label> <input type="text" name="data1" id="data1" />
<label>Wpisz Datę format (yyyy-MM-dd) 
				</label> <input type="text" name="data2" id="data2" />
				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			</div>
			</div>

			<div class="cleaner"></div>
		</div>
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>