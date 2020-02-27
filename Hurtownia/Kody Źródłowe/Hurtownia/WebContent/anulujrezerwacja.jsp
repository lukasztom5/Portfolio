<%@ page import="encje.*" %>
<%@ page import="dao.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
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
		</div></div>
        <div class="spacer2"></div>
       
<% 
Integer idakt= (Integer) session.getAttribute("idaktualne_zamowienie");
AktualneDaoImpl pdi =new AktualneDaoImpl();
AktualneZamowienia p=pdi.findById(idakt);
HistoriaDaoImpl hdi= new HistoriaDaoImpl();
HistoriaZamowienia h=hdi.findById(idakt);

HistoriaWidokDaoImpl hwdi = new HistoriaWidokDaoImpl();
HistoriaWidok hw = hwdi.findByIdhist(h.getIDHISTORIAZAMOWIENIA());
AktualneWidokDaoImpl awdi = new AktualneWidokDaoImpl();
AktualneWidok aw = awdi.findByIdakt(p.getIDAKTUALNEZAMOWIENIE());

CzescDaoImpl cdi = new CzescDaoImpl();
Czesc c=cdi.findById(h.getIDCZESC().getIDCZESC());
CzescDaneDaoImpl kdi2 =new CzescDaneDaoImpl();
CzescWidok kd4=kdi2.findByIdczesc(c.getIDCZESC());

DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
 
  <div id="templatemo_main">
			<h2>Anulowanie Zamówienia</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="AnulujAktualne">
						 <h1>Anulowanie Zamówienia</h1>
						<label>Numer Zamówienia
							 </label>
						 <input type="text" value="<%=p.getIDAKTUALNEZAMOWIENIE()%>" name="idaktualne_zamowienie" id="idaktualne_zamowienie" />
						 <label>Numer Zamówienia-Historia
							 </label>
						 <input type="text" value="<%=h.getIDHISTORIAZAMOWIENIA()%>" name="idhistoria_zamowienie" id="idhistoria_zamowienie" />
							 </label>
						<label>Numer Części
							 </label>
						 <input type="text" value="<%=p.getIDCZESC().getIDCZESC()%>" name="idczesc" id="idczesc" />
							 </label>	 
						
						
						 <label>Status Zamówenia*
							 </label>
				 	  <select id="status" name="status">
  <option  disabled selected><%=hw.getStatus()%></option>
  <option>Anulowano</option>
</select>			 
				 
						 <label>* - pola możliwe do zmiany</label>
						 <button type="submit">Anuluj</button>
						 
						 <div class="spacer"></div>
					 </form>
					 
	 			</div>
			</div>
</div>
        <div id="footer">
            footer
        </div>
</body>
</html>