<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="encje.*"%>
<%@ page import="dao.*"%>
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
<%
UrzadzenieDaoImpl udi = new UrzadzenieDaoImpl();
List<Urzadzenie> lista = udi.findAll();
%>         
        <div class="spacer2"></div>

        <div id="templatemo_main">
			<h2>Formularz dodawania modelu</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="DodajModel">
						<label>Nazwa urzadzenia*
							 </label>
						 <select id="urzadzenie" name="urzadzenie">
  <option  disabled selected>Wybierz nazwę</option>
  <%for(Urzadzenie m1:lista){
  
  UrzadzDaneDaoImpl mddi=new UrzadzDaneDaoImpl();
  UrzadzenieDane md=mddi.findByIdurzadzenie(m1.getIdurzadzenie());

					%>
  <option><%=md.getNazwa()%></option>
  <%} %>
</select>
						
						 <h1>Panel dodawania modelu</h1>
						 <p>Wprowadź dane</p>
						 
						 <label>Firma*
							 </label>
						 <input type="text" name="firma" id="firma" />
						 <label>Model*
						 </label>	 
						 <input type="text" name="model" id="model" />
						 <label>Link Do Zdjęcia*
						 </label>	 
						 <input type="text" name="link" id="link" />
                         <div class="spacer2"></div>
						 <label>* - pola wymagane</label>
						 <button type="submit">Dodaj</button>
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