<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
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
    background: #666;
}

#footer {
    height: 45px;
    clear: left;
    background: #666;
}

#content {
    height: 450px;
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
	padding: 10px 108px;
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
				<a href="cennik.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalog.jsp">Katalog</a>
			</li>
			<li>
				<a href="login.jsp">Logowanie</a>
			</li>
			<li>
				<a href="registry.jsp">Rejestracja</a>
			</li>	
			<li>
				<a href="contact.jsp">Kontakt</a>
			</li>
		</ul>   
            
        </div>

        <center>
        <div id="mystyle" class="myform">
					<h4>Kontakt</h4>
					<h2>W razie pytan prosze skontaktowac z nami: </h2><br />
					<br /> <strong><h2>Telefon (stacjonarne):</strong>(+48) 42-659-11-29</h2><br /> 
					<h2><strong>Telefon(komorkowe):</strong>508-423-122</h2><br />
					<h2>Godziny otwarcia </h2><br />
					<br /> <h2> <strong>Poniedziałek-Piątek: </strong> 9.00 - 17.00</h2></a>
					<h2> <strong>Soboty: </strong> 10.00 - 15.00</h2></a>
					<h2> <strong>Niedziele i Święta: </strong> Nieczynne</h2></a>
           </form>
        </div>
         </center>
			</div>
        <div id="footer">
            Wypożyczalnia 2015
        </div>
    </div>
</body>
</html>