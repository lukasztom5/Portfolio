<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
<title>Wypożyczalnia samochodów</title>
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
    width: 2000px;
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    width: 2000px;
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
	padding: 10px 175px;
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
				<a href="cennikKlient.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalog.jsp">Katalog</a>
			</li>
			<li>
				<a href="history.jsp">Historia</a>
			</li>	
			<li>
				<a href="contactklient.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li>	   
		</ul>   
            
        </div>
       </div> 
       <div id="templatemo_main">
			<h2 align="center">Wyszukiwanie Samochodu</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<h1>Wyszukiwarka aut</h1>
				<p>Po nazwie marki</p>

				<label>Wpisz nazwę marki
				</label> <input type="text" name="marka" id="marka" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<p>Po segmencie</p>

				<label>Wpisz segment
				</label> <input type="text" name="segment" id="segment" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<p>Po rodzaju paliwa</p>

				<label>Podaj rodzaj paliwa
				</label> <input type="text" name="paliwo" id="paliwo" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<h1></h1>
				<p>Po rodzaju skrzyni biegów</p>

				<label>Podaj rodzaj skrzyni biegów
				</label> <input type="text" name="skrzynia_biegow" id="skrzynia_biegow" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<h1></h1>
				<p>Po rodzaju napędu na koła</p>

				<label>Podaj rodzaj napędu na koła
				</label> <input type="text" name="naped_na_kola" id="naped_na_kola" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<h1></h1>
				<p>Po liczbie miejsc</p>

				<label>Podaj liczbę miejsc
				</label> <input type="text" name="liczba_miejsc" id="liczba_miejsc" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzAuto">
				<h1></h1>
				<p>Po liczbie drzwi</p>

				<label>Podaj liczbę drzwi
				</label> <input type="text" name="liczba_drzwi" id="liczba_drzwi" />

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
		</div>
		<div id="templatemo_main">
			<div class="col_w630">
				<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="ZnajdzAutoPoDatach">
				<h1>Wyszukiwarka aut</h1>
				<p>Po datach</p>

				<label>Data Rezeracji format (yyyy-MM-dd)
				</label> <input type="text" name="data1" id="data1" />
<label>Data Zwrotu format (yyyy-MM-dd)
				</label> <input type="text" name="data2" id="data2" />
				<button type="submit">Szukaj</button>
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