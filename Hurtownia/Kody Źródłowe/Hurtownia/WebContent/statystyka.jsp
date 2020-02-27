<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
	<%@page import ="org.jfree.chart.*"%>
<%@page import= "org.jfree.data.category.*"%>
<%@page import= "org.jfree.data.general.DefaultPieDataset"%>
<%@page import= "org.jfree.data.xy.*"%>
<%@page import ="org.jfree.data.*"%>
<%@page import = "org.jfree.chart.renderer.category.*"%>
<%@page import = "org.jfree.chart.plot.*"%>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@page import = "java.awt.*"%>
<%@ page import="java.util.List"%>
<%@ page  import="java.io.*" %>
<%@ page import="encje.*" %>
<%@ page import="dao.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page  import ="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<title>Hurtownia</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-2" />
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
    height: 2000px;
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
        <div id="content">
        <div id="content">
    <%
              Administrator admin = (Administrator) session.getAttribute("admin");
            CzescDaoImpl cdi = new CzescDaoImpl();
            List<Czesc> lista = cdi.findtop();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
for(Czesc c:lista){
	
            CzescDaneDaoImpl cddi = new CzescDaneDaoImpl();
			CzescWidok cw = cddi.findByIdczesc(c.getIDCZESC()) ;           
            ModelDaneDaoImpl mddi = new ModelDaneDaoImpl();
            ModelDaoImpl mdi = new ModelDaoImpl();
            Model mm= mdi.findById(c.getIDMODEL().getIDMODEL());
            ModelDane md = mddi.findByIdmodel(c.getIDMODEL().getIDMODEL());
            UrzadzDaneDaoImpl udi = new UrzadzDaneDaoImpl();
            UrzadzenieDane ud= udi.findByIdurzadzenie(mm.getIDURZADZENIE().getIdurzadzenie());

             dataset.setValue(cw.getIlosc(),md.getModel()+"( "+ud.getNazwa()+" )",cw.getNazwa());
}
JFreeChart chart = ChartFactory.createBarChart3D
            		  ("Wykres wskazujący części najpilniejsze do zamówienia","Części","Ilość sztuk",dataset,PlotOrientation.HORIZONTAL,
            				  true, true, false);

              try {
              final ChartRenderingInfo info = new 
                   ChartRenderingInfo(new StandardEntityCollection());

              final File file1 = new File("C:/Users/Lukasz_Tomczyk/Documents/Hurtownia/WebContent/css/obrazki/Magisterka/barc.png");
            ChartUtilities.saveChartAsPNG(
            file1, chart, 600, 400, info);
              } catch (Exception e) {
            out.println(e);
              }
              
              
           %>
        
				
				
				<%final DefaultPieDataset data = new DefaultPieDataset();
				HistoriaDaoImpl hdi = new HistoriaDaoImpl();
	              ModelDaoImpl mdi = new ModelDaoImpl();
	              List<Model> mm = mdi.findAll();
	            	  for(Model m:mm){
	            		  ModelDaneDaoImpl mddi = new ModelDaneDaoImpl();
	            		  ModelDane mdd = mddi.findByIdmodel(m.getIDMODEL());
	            		  UrzadzDaneDaoImpl udi = new UrzadzDaneDaoImpl();
	                      UrzadzenieDane ud= udi.findByIdurzadzenie(m.getIDURZADZENIE().getIdurzadzenie());
	            		  List<HistoriaZamowienia> mh = hdi.findhi2(m.getIDMODEL());
	            		  int wynik=0;
	            		  for(HistoriaZamowienia hh: mh){
	            			HistoriaWidokDaoImpl hwdi = new HistoriaWidokDaoImpl();
	            			HistoriaWidok hww = hwdi.findByIdhist(hh.getIDHISTORIAZAMOWIENIA());
	            			  
	            			  wynik+=hww.getIlosc();
	            		  }
	            		  if(wynik>0){
	            		  data.setValue(mdd.getModel()+"( "+ud.getNazwa()+" )", wynik);
	            		  }
	            	  }
	            	  
	            	  
	              
	              JFreeChart chart1 = ChartFactory.createPieChart
	            		  ("Wykres modeli urządzeń, do których zamawia się najwięcej części", data, true, true, false);
	              try {
	            	  final ChartRenderingInfo info1 = new 
	            	   ChartRenderingInfo(new StandardEntityCollection());
	            	   final File file2 = new File("C:/Users/Lukasz_Tomczyk/Documents/Hurtownia/WebContent/css/obrazki/Magisterka/pie.png");
	            	   ChartUtilities.saveChartAsPNG(
	            	    file2, chart1, 600, 400, info1);
	            	   } catch (Exception e) {
	            	   out.println(e);
	            	   } %>

    <%
            CzescDaoImpl cdi1 = new CzescDaoImpl();
            DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
            List<Model> mm1 = mdi.findAll();
            String mies[]={"Sty","Lut","Mar","Kwi","Maj","Cze","Lip","Sie","Wrz",
            		"Paz","Lis","Gru"};
      	  for(Model m1:mm1){
      		for(int i=1;i<13;i++){
      		ModelDaneDaoImpl mddi1 = new ModelDaneDaoImpl();
  		  ModelDane mdd1 = mddi1.findByIdmodel(m1.getIDMODEL());
      			List<HistoriaZamowienia> mh = hdi.findhi3(m1.getIDMODEL(), i);
      			UrzadzDaneDaoImpl udi1 = new UrzadzDaneDaoImpl();
                UrzadzenieDane ud1= udi1.findByIdurzadzenie(m1.getIDURZADZENIE().getIdurzadzenie());
      			int wynik1=0;
      			for(HistoriaZamowienia hh: mh){
        			HistoriaWidokDaoImpl hwdi = new HistoriaWidokDaoImpl();
        			HistoriaWidok hww = hwdi.findByIdhist(hh.getIDHISTORIAZAMOWIENIA());
        			  
        			  wynik1+=hww.getIlosc();
        		  }
      			if(wynik1>0){
      			 dataset1.setValue(wynik1,mdd1.getModel()+"( "+ud1.getNazwa()+" )",mies[i-1]);
      			}
      	  }
      	  
}
JFreeChart chart2 = ChartFactory.createBarChart3D
            		  ("Miesięczna sprzedaż części","Miesiąc","Liczba Sztuk",dataset1,PlotOrientation.VERTICAL,
            				  true, true, false);

              try {
              final ChartRenderingInfo info2 = new 
                   ChartRenderingInfo(new StandardEntityCollection());

              final File file3 = new File("C:/Users/Lukasz_Tomczyk/Documents/Hurtownia/WebContent/css/obrazki/Magisterka/barc1.png");
            ChartUtilities.saveChartAsPNG(
            file3, chart2, 600, 400, info2);
              } catch (Exception e) {
            out.println(e);
              }
              
              
           %>	
                       	   
	<%
	Date now = new Date();
	
            DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
            List<Model> mm2 = mdi.findAll();
            
      	  for(Model m1:mm1){
      		  for(int i=3;i>=0;i--){
      			Calendar c = Calendar.getInstance();
      			c.add(Calendar.YEAR, 0-i);
      		ModelDaneDaoImpl mddi1 = new ModelDaneDaoImpl();
  		  ModelDane mdd1 = mddi1.findByIdmodel(m1.getIDMODEL());
  		UrzadzDaneDaoImpl udi1 = new UrzadzDaneDaoImpl();
        UrzadzenieDane ud1= udi1.findByIdurzadzenie(m1.getIDURZADZENIE().getIdurzadzenie());
      			List<HistoriaZamowienia> mh = hdi.findhi4(m1.getIDMODEL(),c.get(Calendar.YEAR));
      			int wynik2=0;
      			for(HistoriaZamowienia hh: mh){
        			HistoriaWidokDaoImpl hwdi = new HistoriaWidokDaoImpl();
        			HistoriaWidok hww = hwdi.findByIdhist(hh.getIDHISTORIAZAMOWIENIA());
        			  
        			  wynik2+=hww.getIlosc();
        		  }
      			if(wynik2>0){
      			 dataset2.setValue(wynik2,mdd1.getModel()+"( "+ud1.getNazwa()+" )",Integer.toString(c.get(Calendar.YEAR)));
      			}
      	  
      		  }
}
JFreeChart chart3 = ChartFactory.createBarChart3D
            		  ("Sprzedaz części w ciągu 4 lat","Rok","Liczba Sztuk",dataset2,PlotOrientation.VERTICAL,
            				  true, true, false);

              try {
              final ChartRenderingInfo info3 = new 
                   ChartRenderingInfo(new StandardEntityCollection());

              final File file4 = new File("C:/Users/Lukasz_Tomczyk/Documents/Hurtownia/WebContent/css/obrazki/Magisterka/barc2.png");
            ChartUtilities.saveChartAsPNG(
            file4, chart3, 600, 400, info3);
              } catch (Exception e) {
            out.println(e);
              }
              
              
           %>	            	   
		<h2>Modele z największą liczbą zamawianych części</h2>
				<img src="css/obrazki/Magisterka/pie.png" width="600" height="400"/>
				<h5>Wykres może określić do których modeli najwięcej zamawia się części w zależności od np awarii urządzenia czy zapotrzebowania produkcji.</h5>	
				<Br>	
			  <h2>Części z najmniejszą liczbą sztuk na magazynie</h2>
				<img src="css/obrazki/Magisterka/barc.png" width="600" height="400"/>
			<Br>	
			  <h2>Miesięczna sprzedaż części dla różnych modeli</h2>
				<img src="css/obrazki/Magisterka/barc1.png" width="600" height="400"/>	
			<Br>	
			  <h2>Zestawienie sprzedaży części dla różnych modeli w ciągu 4 lat</h2>
				<img src="css/obrazki/Magisterka/barc2.png" width="600" height="400"/>		
    </div>
        </div>
        <div id="footer">
            
        </div>
    </div>
</body>
</html>        
