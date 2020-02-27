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
        <div class="spacer2"></div>
<% ModelDaoImpl mdi = new ModelDaoImpl();
List<Model> lista = mdi.findAll();
KategoriaDaoImpl kdi = new KategoriaDaoImpl();
List<Kategoria> lista1 = kdi.findAll();

Administrator admin = (Administrator) session.getAttribute("admin");


%>
</div>
        <div id="templatemo_main">
			<h2>Formularz dodawania czesci dla kategorii</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="DodajCzescK">
						<h1>Panel dodawania czesci</h1>
						 <p>Wprowadź dane</p>
						<label>Kategoria*
							 </label>
						  <select id="idkat" name="idkat">
  <option  disabled selected>Wybierz kategorię</option>
  <%for(Kategoria m1:lista1){
  
  KatDaneDaoImpl mddi=new KatDaneDaoImpl();
  KatWidok kw= mddi.findByIdkat(m1.getIDKATEGORIA());

					%>
  <option><%=kw.getNazwa()%></option>
  <%} %>
</select>
						
						 
						 <label>Model*
							 </label>
						 <select id="idmodel" name="idmodel">
  <option  disabled selected>Wybierz model</option>
  <%for(Model m1:lista){
  
  ModelDaneDaoImpl mddi=new ModelDaneDaoImpl();
  ModelDane md= mddi.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md.getModel()%></option>
  <%} %>
</select>
						 <label>Nazwa*
							 </label>
						 <input type="text" name="nazwa" id="nazwa" />
						 <label>Link Do Zdjęcia*
						 </label>	 
						 <input type="text" name="link" id="link" />
						 <label>Ilość*
							 </label>
						 <input type="text" name="ilosc" id="ilosc" />
						 <label>Cena*
							 </label>
						 <input type="text" name="cena" id="cena" />
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