<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<%@ page contentType="text/html;charset=UTF-8" %>
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
    width: 1320px;
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
<body id="home">
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
		</div></div>
       <div class="spacer2"></div>
<% UrzadzenieDaoImpl udi =new UrzadzenieDaoImpl();
List<Urzadzenie> lista=udi.findAll();
Administrator admin = (Administrator) session.getAttribute("admin");
 Integer idmod = (Integer) session.getAttribute("idmodel");
ModelDaoImpl k=new ModelDaoImpl();
Model w=k.findById(idmod);
ModelDaneDaoImpl mddi = new ModelDaneDaoImpl();
ModelDane md=mddi.findByIdmodel(w.getIDMODEL());
ModelDaoImpl mdi = new ModelDaoImpl();
List<Model> m=mdi.findByurzadznazwa1(md.getModel());
KategoriaDaoImpl kdi=new KategoriaDaoImpl();
CzescDaoImpl cdi = new CzescDaoImpl();
List<Czesc> list=cdi.findByIdmod(w.getIDMODEL());
List<Kategoria> kat=kdi.findBymodelnazwa(md.getModel());

List<Czesc> list2=cdi.findBymodel(md.getModel());


%>
 <div id="templatemo_main">
         
			<h2 align="center">Wyszukiwarka Części dla modelu</h2>
			<div class="col_w630">
			
			<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="SzukajCzescKatPoModelA">
				<p>Po kategorii</p>
<label>Wybierz Model
				</label>
				<select id="id" name="id">
  <option  disabled selected>Wybierz Model</option>
  <%for(Model m1:m){
  
  ModelDaneDaoImpl mddi1=new ModelDaneDaoImpl();
  ModelDane md1=mddi1.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md1.getModel()%></option>
  <%} %>
</select>
				<label>Wybierz kategorię
				</label> <select id="kategoria" name="kategoria">
  <option  disabled selected>Wybierz Kategorię</option>
  <%for(Kategoria k1:kat){
  
	  KatDaneDaoImpl kddi=new KatDaneDaoImpl();
  KatWidok kw1=kddi.findByIdkat(k1.getIDKATEGORIA());

					%>
  <option><%=kw1.getNazwa()%></option>
  <%} %>
</select>

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>
			</form>
		<form id="form" name="form" method="post"
				action="ZnajdzCzescPoModelA">
				<p>Po nazwie</p>
				<label>Wybierz Model
				</label>
				<select id="id" name="id">
  <option  disabled selected>Wybierz Model</option>
  <%for(Model m1:m){
  
  ModelDaneDaoImpl mddi1=new ModelDaneDaoImpl();
  ModelDane md1=mddi1.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md1.getModel()%></option>
  <%} %>
</select>
				<label>Wybierz nazwę części
				</label><select id="nazwa1" name="nazwa1">
  <option  disabled selected>Wybierz Część</option>
  <%for(Czesc cc:list2){
  
	  CzescDaneDaoImpl cddi = new CzescDaneDaoImpl();
  CzescWidok cw=cddi.findByIdczesc(cc.getIDCZESC());

					%>
  <option><%=cw.getNazwa()%></option>
  <%} %>
</select>

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>
			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzCzescPoCenachA">
				<p>W przedziale cenowym</p>
				<label>Wybierz Model
				</label>
				<select id="id2" name="id2">
  <option  disabled selected>Wybierz Model</option>
  <%for(Model m1:m){
  
  ModelDaneDaoImpl mddi1=new ModelDaneDaoImpl();
  ModelDane md1=mddi1.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md1.getModel()%></option>
  <%} %>
</select>
				<label>Wpisz cenę minimalną
				</label> <input type="text" name="cena1" id="cena1" />
<label>Wpisz cenę maksymalną
				</label> <input type="text" name="cena2" id="cena2" />
				<button type="submit">Szukaj</button>
				<div class="spacer"></div>

			</form>
		</div>
<div class="CSSTableGenerator">
<div style="height:250px; overflow:auto"> 
<table >
					<tr>
						<td>Kategoria</td>
					    <td>Nazwa</td>
					    <td>Zdjęcie</td>
					    <td>Ilość</td>
					    <td>Cena za Sztukę</td>
					     <td>Edycja</td>
					     <td>Usuwanie</td>
					</tr>
					<%for(Czesc c:list){
					%>
				
					<tr>
						
						<%
						CzescDaneDaoImpl udi1 =new CzescDaneDaoImpl();
						CzescWidok ud=udi1.findByIdczesc(c.getIDCZESC());
					 	KatDaneDaoImpl ka=new KatDaneDaoImpl();
						KatWidok w1=ka.findByIdkat(c.getIDKATEGORIA().getIDKATEGORIA());
						%>
						<td><%=w1.getNazwa()%></td>
						<td><%=ud.getNazwa()%></td>
						<td><img src="<%=ud.getObraz()%>" width="120" height="120"/></td>
						<td><%=ud.getIlosc()%></td>
						<td><%=ud.getCena()+" zł"%></td>
					<td><a class="more"
							href="WybierzCzescM?idczesc=<%=c.getIDCZESC()%>">Edytuj</a></td>
						<td><a class="more"
							href="UsunCzescM?idczesc=<%=c.getIDCZESC()%>">Usuń</a></td>
						
					</tr>
					
					
					<%} %>
					
					</table>
					</div>
					<ul>

			<li>
					<a href="dodajczescmod.jsp">Dodaj Część</a>
					</li>
					</ul>

			
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
</body>
</html>