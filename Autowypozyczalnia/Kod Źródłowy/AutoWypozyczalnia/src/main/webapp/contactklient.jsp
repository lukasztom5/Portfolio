<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
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
}

#footer {
    height: 45px;
    clear: left;
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
	padding: 10px 111px;
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
				<a href="cennikKlient.jsp">Cennik</a>
			</li>	
			<li>
				<a href="catalogclient.jsp">Katalog</a>
			</li>
			<li>
				<a href="klientHistoriaWypozyczen.jsp">Historia</a>
			</li>	
			<li>
				<a href="contactklient.jsp">Kontakt</a>
			</li>
		    <li>
		       <a href="index.jsp">Wyloguj</a>
		       </li>
		</ul>   
            
        </div>

        <center>
        <div id="mystyle" class="myform">
        <form id="form" name="form" method="post" onsubmit="return validateForm()" action="AdminLogin">
					<h4>Kontakt</h4>
					<h2>W razie pytan prosze skontaktowac z nami: </h2><br />
					<br /> <strong><h2>Telefon (stacjonarne):</strong>(+48) 42-659-11-29</h2><br /> 
					<h2><strong>Telefon(komorkowe):</strong>508-423-122</h2><br />
					<h2> <strong>E-mail:</strong> autowypoz@gmail.com</h2></a>
           </form>
        </div>
         </center>
			</div>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>