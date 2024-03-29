<%@page import="java.util.List"%>
<%@ page import="encje.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
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
<h5 style="line-height: 31px">
				Historia korzystania klienta z usług hurtownii
			</h5>
             <div class="spacer2"></div>
       
<% 
Integer idklient = (Integer) session.getAttribute("idklient");
KlientDaneDaoImpl addi=new KlientDaneDaoImpl();
KlientDane ad=addi.findByIdklient(idklient);
HistoriaDaoImpl hdi =new HistoriaDaoImpl();
List<HistoriaZamowienia> lista=hdi.findByIdkl(ad.getIdklient());
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
Date dateobj = new Date();
%>
<div class="CSSTableGenerator">
<div style="height:250px; overflow:auto"> 
<table>
					<tr>
					<td>Imie i Nazwisko Klienta</td>
						<td>Imie i Nazwisko Pracownika</td>
						<td>Nazwa Części</td>
						<td>Model Urządzenia</td>
						<td>Data Zamówienia</td>
						<td>Status Zamówienia</td>
						<td>Rodzaj Płatności</td>
						<td>Data Realizacji Zamówienia</td>
						<td>Liczba Części</td>
						<td>Cena Za Sztukę</td>
						<td>Cena Całkowita</td>
					</tr>
					
					<%for(HistoriaZamowienia h:lista){
						
						KlientDaoImpl kdi=new KlientDaoImpl();
						Klient k= kdi.findById(idklient);
						
						PracownikDaoImpl pdi = new PracownikDaoImpl();
						Pracownik pw=pdi.findById(h.getIDPRACOWNIK().getIDPRACOWNIK());
						
						HistoriaWidokDaoImpl hwd= new HistoriaWidokDaoImpl();
						HistoriaWidok hw=hwd.findByIdhist(h.getIDHISTORIAZAMOWIENIA());
						
						PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
						PracDane pd=pdi1.findByIdprac(pw.getIDPRACOWNIK());
						
						KlientDaneDaoImpl kdi1 =new KlientDaneDaoImpl();
						KlientDane kd=kdi1.findByIdklient(k.getIDKLIENT());
						
						CzescDaoImpl cz=new CzescDaoImpl();
						Czesc c=cz.findById(h.getIDCZESC().getIDCZESC());
						
						CzescDaneDaoImpl cddi =  new CzescDaneDaoImpl();
						CzescWidok cd=cddi.findByIdczesc(c.getIDCZESC());
						
						ModelDaoImpl m=new ModelDaoImpl();
						Model mw=m.findById(c.getIDMODEL().getIDMODEL());
						
						ModelDaneDaoImpl mddi= new ModelDaneDaoImpl();
						ModelDane md= mddi.findByIdmodel(mw.getIDMODEL());
					%>
					
					<tr>
						<td><%=kd.getImie()+" "+kd.getNazwisko()%></td>
						<td><%=pd.getImie()+" "+pd.getNazwisko()%></td>
						<td><%=cd.getNazwa()%></td>
						<td><%=md.getModel()%></td>
						<td><%=df.format(hw.getDataZamowienia())%></td>
						<td><%=hw.getStatus()%></td>
						<td><%=hw.getPlatnosc()%></td>
						<td><%=df.format(hw.getDataZakonczenia())%></td>
						<td><%=hw.getIlosc()%></td>
						<td><%=hw.getCena()+" zł"%></td>
						<td><%=Float.parseFloat(Double.toString(hw.getSuma()))+" zł"%></td></tr>
					
					<%} %>
					
					</table>
					</div>
        <div class="cleaner"></div>
        </div>
        		<ul>
			<li>
					<a href="KlientAktualneZamowieniaAdmin.jsp">Aktualne Zamówienia</a>
					</li>
					</ul>
        <div id="footer">
            footer
        </div>
    </div>
</body>
</html>