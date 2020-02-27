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
</head>
<body id="home">
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
       <div class="spacer2"></div>
<% Integer idkat = (Integer) session.getAttribute("idkategoria");
KategoriaDaoImpl k=new KategoriaDaoImpl();
KatDaneDaoImpl kddi = new KatDaneDaoImpl();
Kategoria w=k.findById(idkat);
KatWidok kw=kddi.findByIdkat(w.getIDKATEGORIA());
CzescDaoImpl cdi = new CzescDaoImpl();
List<Czesc> list=cdi.findByIdkat(idkat);
Administrator admin = (Administrator) session.getAttribute("admin");

ModelDaoImpl mdi = new ModelDaoImpl();
List<Model> m=mdi.findByurzadznazwa(kw.getNazwa());
List<Kategoria> kww=k.findByurzadznazwa(kw.getNazwa());
List<Czesc> lista=cdi.findBykat(kw.getNazwa());
%>  
			<h2 align="center">Wyszukiwarka Części dla kategorii</h2>
			<div class="col_w630">
			
			
			<div id="mystyle" class="myform">
			<form id="form" name="form" method="post"
				action="SzukajCzescPoFirmaG">
				<p>Po firmie</p>

				<label>Wybierz Kategorię
				</label><select id="id" name="id">
  <option  disabled selected>Wybierz Kategorię</option>
  <%for(Kategoria k1:kww){
  
	  KatDaneDaoImpl mddi=new KatDaneDaoImpl();
  KatWidok kw1=mddi.findByIdkat(k1.getIDKATEGORIA());

					%>
  <option><%=kw1.getNazwa()%></option>
  <%} %>
</select>
				<label>Wybierz nazwę firmy
				</label>
								<select id="firma" name="firma">
  <option  disabled selected>Wybierz Firmę</option>
  <%for(Model m1:m){
  
  ModelDaneDaoImpl mddi=new ModelDaneDaoImpl();
  ModelDane md=mddi.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md.getFirma()%></option>
  <%} %>
</select>

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>
			</form>
		<form id="form" name="form" method="post"
				action="SzukajCzescPoModelMG">
				<p>Po modelu</p>
				<label>Wybierz Kategorię
				</label><select id="id" name="id">
  <option  disabled selected>Wybierz Kategorię</option>
  <%for(Kategoria k1:kww){
  
	  KatDaneDaoImpl mddi=new KatDaneDaoImpl();
  KatWidok kw1=mddi.findByIdkat(k1.getIDKATEGORIA());

					%>
  <option><%=kw1.getNazwa()%></option>
  <%} %>
</select>
				<label>Wybierz model</label>
				<select id="nazwa1" name="nazwa1">
  <option  disabled selected>Wybierz Model</option>
  <%for(Model m1:m){
  
  ModelDaneDaoImpl mddi=new ModelDaneDaoImpl();
  ModelDane md=mddi.findByIdmodel(m1.getIDMODEL());

					%>
  <option><%=md.getModel()%></option>
  <%} %>
</select>

				<button type="submit">Szukaj</button>
				<div class="spacer"></div>
			</form>
			<form id="form" name="form" method="post"
				action="ZnajdzCzescPoCzescG">
				<p>Po nazwie</p>
				<label>Wybierz Kategorię
				</label><select id="id" name="id">
  <option  disabled selected>Wybierz Kategorię</option>
  <%for(Kategoria k1:kww){
  
	  KatDaneDaoImpl mddi=new KatDaneDaoImpl();
  KatWidok kw1=mddi.findByIdkat(k1.getIDKATEGORIA());

					%>
  <option><%=kw1.getNazwa()%></option>
  <%} %>
</select>
				<label>Wybierz część
				</label><select id="czesc" name="czesc">
  <option  disabled selected>Wybierz Część</option>
  <%for(Czesc cc:lista){
  
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
				action="ZnajdzCzescPoCenach1G">
				<p>W przedziale cenowym</p>
				<label>Wybierz Kategorię
				</label><select id="id2" name="id2">
  <option  disabled selected>Wybierz Kategorię</option>
  <%for(Kategoria k1:kww){
  
	  KatDaneDaoImpl mddi=new KatDaneDaoImpl();
  KatWidok kw1=mddi.findByIdkat(k1.getIDKATEGORIA());

					%>
  <option><%=kw1.getNazwa()%></option>
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
		</div>
			
			<div class="cleaner"></div>	
<div class="CSSTableGenerator">
<div style="height:250px; overflow:auto"> 
	<table >
		<tr>
			<td>Firma</td>
			<td>Model</td>
			<td>Zdjęcie</td>
			<td>Nazwa</td>
			<td>Ilość</td>
			<td>Cena za Sztukę</td>
			<td>Zdjęcie</td>
		</tr>
		<%for(Czesc c:list){%>

		<tr>

			<%
				CzescDaneDaoImpl udi1 =new CzescDaneDaoImpl();
				CzescWidok ud=udi1.findByIdczesc(c.getIDCZESC());
				ModelDaneDaoImpl ud2= new ModelDaneDaoImpl(); ModelDane
				w1=ud2.findByIdmodel(c.getIDMODEL().getIDMODEL());
			%>
			<td>
				<%=w1.getFirma()%>
			</td>
			<td>
				<%=w1.getModel()%>
			</td>
			<td>
				<img src="<%=w1.getLink()%>" width="120" height="120" />
			</td>
			<td>
				<%=ud.getNazwa()%>
			</td>
			<td>
				<%=ud.getIlosc()%>
			</td>
			<td>
				<%=ud.getCena()+" zł"%>
			</td>
			<td>
				<img src="<%=ud.getObraz()%>" width="120" height="120" />
			</td>
		</tr>


		<%}%>
					
					</table>
</div>
			
			<div class="cleaner"></div>
		</div>
        <div id="footer">
            footer
        </div>
</body>
</html>