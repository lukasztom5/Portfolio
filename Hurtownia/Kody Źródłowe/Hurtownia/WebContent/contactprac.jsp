<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
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
	padding: 10px 95px;
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
				<a href="czesciprac.jsp">Części AGD</a>
			</li>	
			<li>
				<a href="rozliczeniaprac.jsp">Twoje Rozliczenia</a>
			</li>
			<li>
				<a href="praca.jsp">Twoja Praca</a>
			</li>	
			<li>
				<a href="contactprac.jsp">Kontakt</a>
			</li>
			<li>
		       <a href="index.jsp">Wyloguj</a>
		    </li>  
		</ul>   
            
        </div>

        <center>
        <div id="mystyle" class="myform">
        <form id="form" name="form" method="post" onsubmit="return validateForm()">
					<h4>Kontakt</h4>
					<h2>W razie pytan prosze o się kontaktować </h2><br />
					    </form>
        </div>
         </center>
 <h5 style="line-height: 31px">
				Z Innymi Pracownikami
			</h5>        
        <div class="spacer2"></div>
<% PracownikDaoImpl pdi =new PracownikDaoImpl();
List<Pracownik> lista=pdi.findAll();


%>
 
<div class="CSSTableGenerator">


<table>
					<tr>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Adres Mail</td>
					    <td>Telefon</td>
					    <td>Telefon Służbowy</td>
					</tr>
					<%for(Pracownik p:lista){
					%>
				
					<tr>
						
						<%	PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();

						AdministratorDaoImpl adi=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR().getIDADMINISTRATOR());
						%>
						
						<td><%=pd.getImie()%></td>
						<td><%=pd.getNazwisko()%></td>
						<td><%=pd.getAdresMail()%></td>
						<td><%=pd.getTelefon()%></td>
						<td><%=pd.getTelefonSlużbowy()%></td>
					
					
					<%} %>
					
					</table>
					</div>
<h5 style="line-height: 31px">
				Z Przełożonymi
			</h5>        
        <div class="spacer2"></div>
<% AdministratorDaoImpl adi =new AdministratorDaoImpl();
List<Administrator> lista1=adi.findAll();


%>
 
<div class="CSSTableGenerator">


<table>
					<tr>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Adres Mail</td>
					    <td>Telefon</td>
					</tr>
					<%for(Administrator p:lista1){
					%>
				
					<tr>
						
						<%	
						AdminDaneDaoImpl addi=new AdminDaneDaoImpl();

						AdministratorDaoImpl adi1=new AdministratorDaoImpl();
						AdminDane w1=addi.findByIdAdmin(p.getIDADMINISTRATOR());
						
						%>
						
						<td><%=w1.getImie()%></td>
						<td><%=w1.getNazwisko()%></td>
						<td><%=w1.getAdresMail()%></td>
						<td><%=w1.getTelefon()%></td>
					
					</tr>
					<%} %>
					
					</table>					
					</div>
					
<h5 style="line-height: 31px">
				Z Klientami
			</h5>        
        <div class="spacer2"></div>
<% KlientDaoImpl kdi =new KlientDaoImpl();
List<Klient> lista2=kdi.findAll();


%>
 
<div class="CSSTableGenerator">


<table>
					<tr>
					    <td>Imie</td>
					    <td>Nazwisko</td>
					    <td>Adres Mail</td>
					    <td>Telefon</td>
					</tr>
					<%for(Klient p:lista2){
					%>
				
					<tr>
						
						<%	
						KlientDaneDaoImpl kddi=new KlientDaneDaoImpl();

						KlientDane w2=kddi.findByIdklient(p.getIDKLIENT());
						
						%>
						
						<td><%=w2.getImie()%></td>
						<td><%=w2.getNazwisko()%></td>
						<td><%=w2.getAdres_mail()%></td>
						<td><%=w2.getTelefon()%></td>
					
					</tr>
					<%} %>
					
					</table>					
					</div>					
					<div class="cleaner"></div>
					<ul>
					</ul>

         <div id="footer">
        </div>
</body>
</html>