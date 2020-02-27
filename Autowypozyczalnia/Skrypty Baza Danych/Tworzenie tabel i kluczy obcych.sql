create database wypozyczalnia;
create table auta(
idauta int primary key,
marka varchar(50),
model varchar(50),
segment varchar(50),
paliwo varchar(50),
skrzynia_biegow varchar(50),
numer_rejestracyjny varchar(50),
numer_VIN varchar(50),
numer_nadwozia varchar(50),
numer_silnika varchar(50),
rocznik varchar(50),
kolor varchar(50),
moc_silnika_KM varchar(50),
naped_na_kola varchar(100),
liczba_miejsc varchar(50),
liczba_drzwi varchar(50),
pojemnosc_bagaznika_w_litrach varchar(50),
zuzycie_paliwa_na_100_km varchar(50),
idadministrator int,
idmarka int,
idkolor int,
idsegment int
)
create table klient
(
idklient int primary key,
imie varchar(100),
nazwisko varchar(100),
pesel varchar(11),
miasto varchar(100),
adres varchar(100),
adres_mail varchar(100),
telefon varchar(9),
login varchar(100),
haslo varchar(100)
)
create table administrator
(
idadministrator int primary key,
imie varchar(100),
nazwisko varchar(100),
miasto varchar(20),
adres varchar(100),
login varchar(100),
haslo varchar(100),
idaktualne_wypozyczenie int,
idhistoria_wypozyczenia int
)
create table aktualne_wypozyczenie
(
idaktualne_wypozyczenie int primary key,
klientid int,
autoid int,
marka varchar(100),
model varchar(100),
imie varchar(100),
nazwisko varchar(100),
data_rezerwacja date,
data_zwrotu date,
idauta int,
idadministrator int,
idklient int
)
create table wyposazenie
(
idwyposazenie int primary key,
dodatek varchar(100),
cena_dzien float
)
create table auto_wyposazenie
(
idauta int,
idwyposazenie int
PRIMARY KEY (idauta, idwyposazenie)
)
create table kolor(
idkolor int primary key,
kolor_nadwozia varchar(20)
)
create table segment(
idsegment int primary key,
rodzaj varchar(20),
cena_za_dobe int
)
create table historia_wypozyczenia
(
idhistoria_wypozyczenia int primary key,
klientid int,
autoid int,
marka varchar(100),
model varchar(100),
imie varchar(100),
nazwisko varchar(100),
termin_wypozyczenia date,
termin_oddania date,
liczba_dni int,
cena_segment int,
cena_dodatek float,
wyposazenie varchar(1000),
dodatkowy_koszt float,
uwagi varchar(3000),
kilometry int,
stawka_segment_wyposazenie float,
status_zaliczka varchar(100),
idauta int,
idklient int,
idadministrator int
)
create table marka
(
idmarka int primary key,
nazwa varchar(50),
kraj varchar(50)
)
ALTER TABLE auta ADD CONSTRAINT FK_auta_kolor_auta FOREIGN KEY (idkolor) REFERENCES kolor(idkolor) 
ALTER TABLE auta ADD CONSTRAINT FK_auta_marka_auta FOREIGN KEY (idmarka) REFERENCES marka(idmarka)
ALTER TABLE auta ADD CONSTRAINT FK_auta_administrator_auta FOREIGN KEY (idadministrator) REFERENCES administrator(idadministrator)
ALTER TABLE auta ADD CONSTRAINT FK_segment_marka_segment FOREIGN KEY (idsegment) REFERENCES segment(idsegment)
ALTER TABLE auto_wyposazenie ADD CONSTRAINT FK_auta_wyposazenie_auta FOREIGN KEY (idauta) REFERENCES auta(idauta)
ALTER TABLE auto_wyposazenie ADD CONSTRAINT FK_auta_wyposazenie_wyposazenie FOREIGN KEY (idwyposazenie) REFERENCES wyposazenie(idwyposazenie)
ALTER TABLE historia_wypozyczenia ADD CONSTRAINT FK_auta_klient_auta FOREIGN KEY (idauta) REFERENCES auta(idauta)
ALTER TABLE historia_wypozyczenia ADD CONSTRAINT FK_auta_klient_klient FOREIGN KEY (idklient) REFERENCES klient(idklient)
ALTER TABLE historia_wypozyczenia ADD CONSTRAINT FK_administrator_historia_wypozyczenia_administrator FOREIGN KEY (idadministrator) REFERENCES administrator(idadministrator)
ALTER TABLE aktualne_wypozyczenie ADD CONSTRAINT FK_administrator_aktualne_wypozyczenie_administrator FOREIGN KEY (idadministrator) REFERENCES administrator(idadministrator)
ALTER TABLE aktualne_wypozyczenie ADD CONSTRAINT FK_klient_aktualne_wypozyczenie_klient FOREIGN KEY (idklient) REFERENCES klient(idklient)
ALTER TABLE aktualne_wypozyczenie ADD CONSTRAINT FK_auta_aktualne_wypozyczenie_auta FOREIGN KEY (idauta) REFERENCES auta(idauta)

