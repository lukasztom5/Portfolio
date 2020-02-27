<%@ page import="encje.Pracownik" %>
<%@ page import="encje.PracDane" %>
<%@ page import="dao.PracownikDaoImpl" %>
<%@ page import="dao.PracDaneDaoImpl" %>
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
		</div></div>
        <div class="spacer2"></div>
       
<% 
Integer idpracownik = (Integer) session.getAttribute("idpracownik");
PracownikDaoImpl pdi =new PracownikDaoImpl();
Pracownik p=pdi.findById(idpracownik);
PracDaneDaoImpl pdi1 =new PracDaneDaoImpl();
PracDane pd=pdi1.findByIdprac(p.getIDPRACOWNIK());
HttpSession sess = request.getSession();
sess.setAttribute("PRACOWNIK", p);
%>
 
  <div id="templatemo_main">
			<h2>Modyfikacja Danych Pracownika</h2>
			<div class="col_w630">
				<div id="mystyle" class="myform">
					 <form id="form" name="form2" method="post" onsubmit="return validateForm()" action="PracownikModify">
						 <h1>Modyfikacja</h1>
						 <p>Zmień Dane</p>
						  <label>Numer Identyfikacyjny
						
							 </label>
						 <input type="text" value="<%=p.getIDPRACOWNIK()%>" name="id" id="id" />
							 </label>
						 <label>Imie*
							 </label>
						 <input type="text" value="<%=pd.getImie()%>" name="imie" id="imie" />
						 <label>Nazwisko*
						 </label>	 
						 <input type="text" value="<%=pd.getNazwisko()%>" name="nazwisko" id="nazwisko" />
						
						<label>Kraj*
							 </label>
						 <input type="text" value="<%=pd.getKraj()%>" name="kraj" id="kraj" />
						
						 <label>Miasto*
							 </label>
						 <input type="text" value="<%=pd.getMiasto()%>" name="miasto" id="miasto" />

						 <label>Adres Zamieszkania*
							  </label>
						 <input type="text" value="<%=pd.getAdres()%>" name="adres" id="sadres" />
						 <label>Adres Mail*
							 </label>
						 <input type="text" value="<%=pd.getAdresMail()%>" name="adres_mail" id="adres_mail" />
				 <label>Telefon*
							</label> 
						 <input type="text" value="<%=pd.getTelefon()%>" name="telefon" id="telefon" />
						  <label>Telefon Służbowy*
							</label> 
						 <input type="text" value="<%=pd.getTelefonSlużbowy()%>" name="telefon_sluzbowy" id="telefon_sluzbowy" />
						 <label>Numer Konta*
							</label> 
						 <input type="text" value="<%=pd.getNumerKonta()%>" name="numer_konta" id="numer_konta" />
						 <label>Pensja*
							</label> 
						 <input type="text" value="<%=pd.getPensja()%>" name="pensja" id="pensja" />
							 <label>Data Zatrudnienia*
							</label> 
						 <input type="text" value="<%=pd.getDataZatrudnienia()%>" name="data_zatrudnienia" id="data_zatrudnienia" />
						 <label>Data Zakończenia*
							</label> 
						 <input type="text" value="<%=pd.getDataZakonczenia()%>" name="data_zakonczenia" id="data_zakonczenia" />
						 <label>Login*
							</label> 
						 <input type="text" value="<%=p.getLOGIN()%>" name="login" id="login" />
						 <label>Hasło (min. 8 znaków)*
							  </label>
						 <input type="text" value="<%=p.getHASLO()%>" name="haslo" id="haslo" />
                         <div class="spacer2"></div>
						 <label>* - pola do zmiany</label>
						 <button type="submit">Zmień</button>
						 
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