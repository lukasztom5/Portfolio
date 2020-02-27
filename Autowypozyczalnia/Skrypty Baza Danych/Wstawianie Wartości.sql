select *from kolor
insert into kolor values(1,'Czarny')
insert into kolor values(2,'Bialy')
insert into kolor values(3,'Zolty')
insert into kolor values(4,'Niebieski')
insert into kolor values(5,'Zielony')
insert into kolor values(6,'Srebrny')
insert into kolor values(7,'Bezowy')
insert into kolor values(8,'Szary')
insert into kolor values(9,'Czerwony')
delete from kolor
select *from marka
insert into marka values(next value for S_Marka,'Fiat','Wlochy')
insert into marka values(next value for S_Marka,'Alfa Romeo','Wlochy')
insert into marka values(next value for S_Marka,'Lancia','Wlochy')
insert into marka values(next value for S_Marka,'Peugeot','Francja')
insert into marka values(next value for S_Marka,'Citroen','Francja')
insert into marka values(next value for S_Marka,'Renault','Francja')
insert into marka values(next value for S_Marka,'Volkswagen','Niemcy')
insert into marka values(next value for S_Marka,'Opel','Niemcy')
insert into marka values(next value for S_Marka,'Audi','Niemcy')
insert into marka values(next value for S_Marka,'Ford','Niemcy/Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Mercedes-Benz','Niemcy')
insert into marka values(next value for S_Marka,'BMW','Niemcy')
insert into marka values(next value for S_Marka,'Rover','Wielka Brytania')
insert into marka values(next value for S_Marka,'Jaguar','Wielka Brytania')
insert into marka values(next value for S_Marka,'Lotus','Wielka Brytania')
insert into marka values(next value for S_Marka,'Land Rover','Wielka Brytania')
insert into marka values(next value for S_Marka,'Volvo','Szwecja')
insert into marka values(next value for S_Marka,'Saab','Szwecja')
insert into marka values(next value for S_Marka,'Bentley','Wielka Brytania')
insert into marka values(next value for S_Marka,'Skoda','Czechy')
insert into marka values(next value for S_Marka,'Dacia','Rumunia')
insert into marka values(next value for S_Marka,'Kia','Korea Poludniowa')
insert into marka values(next value for S_Marka,'Huyndai','Korea Poludniowa')
insert into marka values(next value for S_Marka,'Daewoo','Korea Poludniowa/Polska')
insert into marka values(next value for S_Marka,'Honda','Japonia')
insert into marka values(next value for S_Marka,'Toyota','Japonia')
insert into marka values(next value for S_Marka,'Nissan','Japonia')
insert into marka values(next value for S_Marka,'Mazda','Japonia')
insert into marka values(next value for S_Marka,'Lexus','Japonia')
insert into marka values(next value for S_Marka,'Mitsubishi','Japonia')
insert into marka values(next value for S_Marka,'Infiniti','Japonia')
insert into marka values(next value for S_Marka,'Mini','Wielka Brytania')
insert into marka values(next value for S_Marka,'Tata','Indie')
insert into marka values(next value for S_Marka,'Seat','Hiszpania')
insert into marka values(next value for S_Marka,'Chevrolet','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Dodge','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Chrysler','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'GMC','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Cadillac','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Jeep','Stany Zjednoczone')
insert into marka values(next value for S_Marka,'Maserati','Wlochy')
insert into marka values(next value for S_Marka,'Smart','Francja')
insert into marka values(next value for S_Marka,'Suzuki','Japonia')
insert into marka values(next value for S_Marka,'Porsche','Niemcy')

select*from wyposazenie
insert into wyposazenie values(1,'Nawigacja GPS',30)
insert into wyposazenie values(2,'Fotelik Dzieciêcy',10)
insert into wyposazenie values(3,'Baga¿nik Dachowy',20)
insert into wyposazenie values(4,'£añcuchy Na Ko³a',6)
insert into wyposazenie values(5,'Baga¿nik Rowerowy',15)
insert into wyposazenie values(6,'Zimowe Opony',20)

select*from segment
insert into segment values(next value for S_Segment,'A',70)
insert into segment values(next value for S_Segment,'B',80)
insert into segment values(next value for S_Segment,'C',120)
insert into segment values(next value for S_Segment,'D',180)
insert into segment values(next value for S_Segment,'E',200)
insert into segment values(next value for S_Segment,'F',250)
insert into segment values(next value for S_Segment,'G',500)
insert into segment values(next value for S_Segment,'Kabriolet',200)
insert into segment values(next value for S_Segment,'SUV',170)
insert into segment values(next value for S_Segment,'VAN',170)
insert into segment values(next value for S_Segment,'R',250)

select *from administrator
insert into administrator values(next value for S_Administrator,'£ukasz','Tomczyk','£ódŸ','Nastrojowa 54 M 37','lukasztom5','avatar2010',NULL,NULL)

select *from auta 
delete from auta
insert into auta values('1','Fiat','Panda','A','Benzyna','Manualna','EL124ER','SUZFA7G11GW234531','SUZFA7G11GW234531','FT70CMTS',2007,'Niebieski',70,'Przedni',5,5,206,6,NULL,NULL,NULL,NULL)
insert into auta values('2','Ford','Ka','A','Diesel','Manualna','EZG452KW','SN1FBT13RWS654211','SN1FBT13RWS654211','FL75DMDS',2009,'Czerwony',75,'Przedni',4,3,224,5,NULL,NULL,NULL,NULL)
insert into auta values('3','Skoda','Citigo','A','Benzyna','Manualna','WR542HP','TPSKO3423FG453219','TPSKO3423FG453219','FL60BMDS',2012,'Zielony',60,'Przedni',4,5,251,5,NULL,NULL,NULL,NULL)
insert into auta values('4','Renault','Twingo','A','Gaz','Automatyczna','WWR95JH','VFVF1TR1142664532','VFVF1TR1142664532','FT75CMDS',2010,'¯ó³ty',75,'Przedni',4,3,230,7,NULL,NULL,NULL,NULL)
insert into auta values('5','Toyota','Aygo','A','Benzyna','Manualna','TRZ143ER','JJT143JH4TRT45654','JJT143JH4TRT45654','FL54DMTS',2013,'Czerwony',54,'Przedni',4,5,138,4,NULL,NULL,NULL,NULL)
insert into auta values('6','Chevrolet','Spark','A','Gaz','Automatyczna','TT124ER','KL1GC6453JHK76453','KL1GC6453JHK76453','FT81EMTS',2011,'Bia³y',81,'Przedni',5,5,170,7,NULL,NULL,NULL,NULL)

insert into auta values('7','Ford','Fiesta','B','Benzyna','Manualna','KWA531TR','SO1FC64643TRTR54RR','SO1FC64643TRTR54RR','F96BEDL',2010,'Niebieski',96,'Przedni',5,5,295,6,NULL,NULL,NULL,NULL)
insert into auta values('8','Suzuki','Swift','B','Gaz','Manualna','ESK543LN','JJSKRT3545UT65451','JJSKRT3545UT65451','FT94CETL',2011,'Bia³y',94,'Przedni',5,5,211,7,NULL,NULL,NULL,NULL)
insert into auta values('9','Seat','Ibiza','B','Diesel','Manualna','WR654TRE','VSVSS56563TR34238','VSVSS56563TR34238','FT75DMDl',2009,'¯ó³ty',75,'Przedni',5,5,292,6,NULL,NULL,NULL,NULL)
insert into auta values('10','Skoda','Fabia','B','Benzyna','Manualna','EL170CP','TNSKO76754FR45321','TNSKO76754FR45321','FT64EEDL',2007,'Be¿owy',64,'Przedni',5,5,438,6,NULL,NULL,NULL,NULL)
insert into auta values('11','Renault','Clio','B','Benzyna','Automatyczna','SG423TR','VFVF154543HG67654','VFVF154543HG67654','FT115CMTS',2012,'Czerwony',115,'Przedni',5,5,300,5,NULL,NULL,NULL,NULL)
insert into auta values('12','Citroen','C3','B','Diesel','Manualna','BI948ER','VFVF74533HYG7654','VFVF74533HYG7654','FT90CHTS',2005,'Niebieski',90,'Przedni',5,5,305,6,NULL,NULL,NULL,NULL)


CREATE SEQUENCE S_Marka
 AS INT
 START WITH 1
 INCREMENT BY 1
GO
CREATE SEQUENCE S_Segment
 AS INT
 START WITH 1
 INCREMENT BY 1
GO
CREATE SEQUENCE S_Administrator
 AS INT
 START WITH 1
 INCREMENT BY 1
GO
