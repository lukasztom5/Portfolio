CREATE TABLE IO_KRAJ(
ID_KRAJ INTEGER NOT NULL PRIMARY KEY,
KRAJ VARCHAR(MAX)
)
CREATE TABLE IO_MIASTO(
ID_MIASTO INTEGER NOT NULL PRIMARY KEY,
MIASTO VARCHAR(MAX)
)
CREATE TABLE IO_MIASTO_KRAJ(
ID_MK INTEGER NOT NULL PRIMARY KEY,
ID_MIASTO INTEGER REFERENCES IO_MIASTO(ID_MIASTO),
ID_KRAJ INTEGER REFERENCES IO_KRAJ(ID_KRAJ),
)
CREATE TABLE IO_KANDYDATURA(
ID_KANDYDATURA INTEGER NOT NULL PRIMARY KEY,
ID_MK INTEGER REFERENCES IO_MIASTO_KRAJ(ID_MK),
ROK_IGRZYSK INTEGER,
STATUS VARCHAR(MAX),
LETNIE_CZY_ZIMOWE VARCHAR(MAX),
INFORMACJE VARCHAR(MAX)
)
CREATE TABLE IO_IGRZYSKA_OLIMPIJSKIE(
ID_IO INTEGER NOT NULL PRIMARY KEY,
ID_KAN INTEGER REFERENCES IO_KANDYDATURA(ID_KANDYDATURA),
ROK INTEGER,
NUMER_IGRZYSK INTEGER,
LICZBA_SPORTOW INTEGER,
DYSCYPLINY INTEGER,
KONKURENCJE INTEGER,
LICZBA_REPREZENTACJI INTEGER,
LICZBA_MEZCZYZN INTEGER,
LICZBA_KOBIET INTEGER,
LICZBA_SPORTOWCOW INTEGER,
DATA_ROZPOCZECIA DATE,
DATA_ZAKONCZENIA DATE,
KTO_OTWIERAL VARCHAR(MAX)
)
CREATE TABLE IO_SPORT(
ID_SPORT INTEGER NOT NULL PRIMARY KEY,
SPORT VARCHAR(MAX)
)
CREATE TABLE IO_DYSCYPLINY(
ID_DYSCYPLINA INTEGER NOT NULL PRIMARY KEY,
ID_SPORT INTEGER REFERENCES IO_SPORT(ID_SPORT),
DYSCYPLINA VARCHAR(MAX)
)
CREATE TABLE IO_PLEC(
ID_PLEC INTEGER NOT NULL PRIMARY KEY,
PLEC VARCHAR(MAX)
)
CREATE TABLE IO_KONKURENCJA(
ID_KONKURENCJA INTEGER NOT NULL PRIMARY KEY,
ID_DYSCYPLINA INTEGER REFERENCES IO_DYSCYPLINY(ID_DYSCYPLINA),
ID_PLEC INTEGER REFERENCES IO_PLEC(ID_PLEC),
NAZWA VARCHAR(MAX)
)
CREATE TABLE IO_IO_KONKURENCJA(
ID_KIO INTEGER NOT NULL PRIMARY KEY,
ID_IO INTEGER REFERENCES IO_IGRZYSKA_OLIMPIJSKIE(ID_IO),
ID_KONKURENCJA INTEGER REFERENCES IO_KONKURENCJA(ID_KONKURENCJA),
ROK INTEGER
)
CREATE TABLE IO_REPREZENTACJA(
ID_REPREZENTACJA INTEGER NOT NULL PRIMARY KEY,
NAZWA VARCHAR(MAX),
ZLOTE_LETNIE INTEGER,
SREBRNE_LETNIE INTEGER,
BRAZOWE_LETNIE INTEGER,
ZLOTE_ZIMOWE INTEGER,
SREBRNE_ZIMOWE INTEGER,
BRAZOWE_ZIMOWE INTEGER,
ZLOTE_MEDALE INTEGER,
SREBRNE_MEDALE INTEGER,
BRAZOWE_MEDALE INTEGER,
SUMA_MEDALI INTEGER
)
CREATE TABLE IO_IO_REPREZENTACJA(
ID_IO_R INTEGER NOT NULL PRIMARY KEY,
ID_REPREZENTACJA INTEGER REFERENCES IO_REPREZENTACJA(ID_REPREZENTACJA),
ID_IO INTEGER REFERENCES IO_IGRZYSKA_OLIMPIJSKIE(ID_IO),
MIEJSCE INTEGER,
ZLOTO INTEGER,
SREBRO INTEGER,
BRAZ INTEGER,
DODATKOWE_INFORMACJE VARCHAR(MAX),
ZIMOWE_WYSTEP BIT
)
CREATE TABLE IO_KONK_REP(
ID_KR INTEGER NOT NULL PRIMARY KEY,
ID_KIO INTEGER REFERENCES IO_IO_KONKURENCJA(ID_KIO),
ID_IO_R INTEGER REFERENCES IO_IO_REPREZENTACJA(ID_IO_R),
ROK INTEGER,
MIEJSCE INTEGER
)
CREATE TABLE IO_MEDALISCI(
ID_MEDALISTA INTEGER NOT NULL PRIMARY KEY,
IMIE VARCHAR(MAX),
NAZWISKO VARCHAR(MAX),
ZLOTE_MEDALE INTEGER,
SREBRNE_MEDALE INTEGER,
BRAZOWE_MEDALE INTEGER,
LICZBA_MEDALI_SUMA INTEGER,
LGBT VARCHAR(MAX),
DODATKOWE_INFORMACJE VARCHAR(MAX)
)
CREATE TABLE IO_MEDALISCI_IO(
ID_MEDALISTA INTEGER REFERENCES IO_MEDALISCI(ID_MEDALISTA),
ID_IO INTEGER REFERENCES IO_IGRZYSKA_OLIMPIJSKIE(ID_IO),
ROK INTEGER,
ZLOTE_MEDALE INTEGER,
SREBRNE_MEDALE INTEGER,
BRAZOWE_MEDALE INTEGER
)
CREATE TABLE IO_MEDALISTA_REPREZENTACJA(
ID_MEDALISTA INTEGER REFERENCES IO_MEDALISCI(ID_MEDALISTA),
ID_REPREZENTACJA INTEGER REFERENCES IO_REPREZENTACJA(ID_REPREZENTACJA)
)
CREATE TABLE IO_KONKURENCJA_MEDALISTA(
ID_KR INTEGER REFERENCES IO_KONK_REP(ID_KR),
ID_IO_R INTEGER REFERENCES IO_IO_REPREZENTACJA(ID_IO_R),
ID_MEDALISTA INTEGER REFERENCES IO_MEDALISCI(ID_MEDALISTA),
ROK INTEGER,
MIEJSCE INTEGER
)

TRUNCATE TABLE IO_KONKURENCJA_MEDALISTA

ALTER TABLE IO_KRAJ$ ALTER COLUMN ID_KRAJ INTEGER
ALTER TABLE IO_MIASTO$ ALTER COLUMN ID_MIASTO INTEGER
ALTER TABLE IO_MIASTO_KRAJ$ ALTER COLUMN ID_MK INTEGER
ALTER TABLE IO_MIASTO_KRAJ$ ALTER COLUMN ID_MIASTO INTEGER
ALTER TABLE IO_MIASTO_KRAJ$ ALTER COLUMN ID_KRAJ INTEGER
ALTER TABLE IO_KANDYDATURA$ ALTER COLUMN ID_KANDYDATURA INTEGER
ALTER TABLE IO_KANDYDATURA$ ALTER COLUMN ID_MK INTEGER
ALTER TABLE IO_KANDYDATURA$ ALTER COLUMN ROK_IGRZYSK INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN ID_IO INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN ID_KAN INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN ROK INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN NUMER_IGRZYSK INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN DYSCYPLINY INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN KONKURENCJE INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN LICZBA_REPREZENTACJI INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN LICZBA_MEZCZYZN INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN LICZBA_KOBIET INTEGER
ALTER TABLE IO_IGRZYSKA_OLIMPIJSKIE$ ALTER COLUMN LICZBA_SPORTOWCOW INTEGER
ALTER TABLE IO_SPORT$ ALTER COLUMN ID_SPORT INTEGER
ALTER TABLE IO_DYSCYPLINY$ ALTER COLUMN ID_DYSCYPLINA INTEGER
ALTER TABLE IO_DYSCYPLINY$ ALTER COLUMN ID_SPORT INTEGER
ALTER TABLE IO_PLEC$ ALTER COLUMN ID_PLEC INTEGER
ALTER TABLE IO_KONKURENCJA$ ALTER COLUMN ID_KONKURENCJA INTEGER
ALTER TABLE IO_KONKURENCJA$ ALTER COLUMN ID_DYSCYPLINA INTEGER
ALTER TABLE IO_KONKURENCJA$ ALTER COLUMN ID_PLEC INTEGER
ALTER TABLE IO_IO_KONKURENCJA$ ALTER COLUMN ID_KIO INTEGER
ALTER TABLE IO_IO_KONKURENCJA$ ALTER COLUMN ID_IO INTEGER
ALTER TABLE IO_IO_KONKURENCJA$ ALTER COLUMN ID_KONKURENCJA INTEGER
ALTER TABLE IO_IO_KONKURENCJA$ ALTER COLUMN ROK INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN ID_REPREZENTACJA INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN ZLOTO_LETNIE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN SREBRNE_LATO INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN BRAZOWE_LATO INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN ZLOTE_ZIMOWE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN SREBRNE_ZIMOWE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN BRAZOWE_ZIMOWE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN ZLOTE_MEDALE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN SREBNE_MEDALE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN BRAZOWE_MEDALE INTEGER
ALTER TABLE IO_REPREZENTACJA$ ALTER COLUMN F12 INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN IO_IO_R INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN ID_REPREZENTACJA INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN ID_IO INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN MIEJSCE INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN ZLOTO INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN SREBRO INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN BRAZ INTEGER
ALTER TABLE IO_IO_REPREZENTACJA$ ALTER COLUMN F11 BIT
ALTER TABLE IO_KONK_REP$ ALTER COLUMN ID_KR INTEGER
ALTER TABLE IO_KONK_REP$ ALTER COLUMN ID_KIO INTEGER
ALTER TABLE IO_KONK_REP$ ALTER COLUMN ID_IO_R INTEGER
ALTER TABLE IO_KONK_REP$ ALTER COLUMN ROK INTEGER
ALTER TABLE IO_KONK_REP$ ALTER COLUMN MIEJSCE INTEGER
ALTER TABLE IO_MEDALISCI$ ALTER COLUMN ID_MEDALISTA INTEGER
ALTER TABLE IO_MEDALISCI$ ALTER COLUMN ZLOTE_MEDALE INTEGER
ALTER TABLE IO_MEDALISCI$ ALTER COLUMN SREBRNE_MEDALE INTEGER
ALTER TABLE IO_MEDALISCI$ ALTER COLUMN BRAZOWE_MEDALE INTEGER
ALTER TABLE IO_MEDALISCI$ ALTER COLUMN LICZBA_MEDALI_SUMA INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN ID_MEDALISTA INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN ID_IO INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN ROK INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN ZLOTE_MEDALE INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN SREBRNE_MEDALE INTEGER
ALTER TABLE IO_MEDALISCI_IO$ ALTER COLUMN BRAZOWE_MEDALE INTEGER
ALTER TABLE IO_MEDALISTA_REPREZENTACJA$ ALTER COLUMN ID_MEDALISTA INTEGER
ALTER TABLE IO_MEDALISTA_REPREZENTACJA$ ALTER COLUMN ID_REPREZENTACJA INTEGER
ALTER TABLE IO_KONKURENCJA_MEDALISTA$ ALTER COLUMN ID_KR INTEGER
ALTER TABLE IO_KONKURENCJA_MEDALISTA$ ALTER COLUMN ID_IO_R INTEGER
ALTER TABLE IO_KONKURENCJA_MEDALISTA$ ALTER COLUMN ID_MEDALISTA INTEGER
ALTER TABLE IO_KONKURENCJA_MEDALISTA$ ALTER COLUMN ROK INTEGER
ALTER TABLE IO_KONKURENCJA_MEDALISTA$ ALTER COLUMN MIEJSCE INTEGER

INSERT INTO IO_KRAJ SELECT * FROM IO_KRAJ$
INSERT INTO IO_MIASTO SELECT * FROM IO_MIASTO$
INSERT INTO IO_MIASTO_KRAJ SELECT ID_MK,ID_MIASTO,ID_KRAJ FROM IO_MIASTO_KRAJ$
INSERT INTO IO_KANDYDATURA SELECT ID_KANDYDATURA,ID_MK,ROK_IGRZYSK,STATUS,LETNIE_CZY_ZIMOWE,INFORMACJE FROM IO_KANDYDATURA$
INSERT INTO IO_IGRZYSKA_OLIMPIJSKIE SELECT ID_IO,ID_KAN,ROK,NUMER_IGRZYSK,LICZBA_SPORTOW,DYSCYPLINY,KONKURENCJE,LICZBA_REPREZENTACJI,
LICZBA_MEZCZYZN,LICZBA_KOBIET,LICZBA_SPORTOWCOW,DATA_ROZPOCZECIA,DATA_ZAKONCZENIA,KTO_OTWIERAL FROM IO_IGRZYSKA_OLIMPIJSKIE$
INSERT INTO IO_SPORT SELECT * FROM IO_SPORT$
INSERT INTO IO_DYSCYPLINY SELECT * FROM IO_DYSCYPLINY$
INSERT INTO IO_PLEC SELECT * FROM IO_PLEC$
INSERT INTO IO_KONKURENCJA SELECT * FROM IO_KONKURENCJA$
INSERT INTO IO_IO_KONKURENCJA SELECT * FROM IO_IO_KONKURENCJA$
INSERT INTO IO_REPREZENTACJA SELECT * FROM IO_REPREZENTACJA$
INSERT INTO IO_IO_REPREZENTACJA SELECT IO_IO_R,ID_REPREZENTACJA,ID_IO,MIEJSCE,ZLOTO,SREBRO,BRAZ,DODATKOWE_INFORMACJE,F11 FROM IO_IO_REPREZENTACJA$
INSERT INTO IO_KONK_REP SELECT ID_KR,ID_KIO,ID_IO_R,ROK,MIEJSCE FROM IO_KONK_REP$
INSERT INTO IO_MEDALISCI SELECT * FROM IO_MEDALISCI$
INSERT INTO IO_MEDALISCI_IO SELECT ID_MEDALISTA,ID_IO,ROK,ZLOTE_MEDALE,SREBRNE_MEDALE,BRAZOWE_MEDALE FROM IO_MEDALISCI_IO$
INSERT INTO IO_MEDALISTA_REPREZENTACJA SELECT ID_MEDALISTA,ID_REPREZENTACJA FROM IO_MEDALISTA_REPREZENTACJA$ 
INSERT INTO IO_KONKURENCJA_MEDALISTA SELECT ID_KR,ID_IO_R,ID_MEDALISTA,ROK,MIEJSCE FROM IO_KONKURENCJA_MEDALISTA$ WHERE ID_KR IS NOT NULL 

SELECT * FROM IO_MIASTO
SELECT * FROM IO_MIASTO_KRAJ
SELECT * FROM IO_KANDYDATURA
SELECT * FROM IO_IGRZYSKA_OLIMPIJSKIE
SELECT * FROM IO_SPORT
SELECT * FROM IO_DYSCYPLINY
SELECT * FROM IO_PLEC
SELECT * FROM IO_KONKURENCJA
SELECT * FROM IO_IO_KONKURENCJA
SELECT * FROM IO_REPREZENTACJA
SELECT * FROM IO_IO_REPREZENTACJA
SELECT * FROM IO_KONK_REP
SELECT * FROM IO_MEDALISCI
SELECT * FROM IO_MEDALISCI_IO
SELECT * FROM IO_MEDALISTA_REPREZENTACJA
SELECT * FROM IO_KONKURENCJA_MEDALISTA ORDER BY ID_KR

DROP TABLE IO_DYSCYPLINY$, IO_IGRZYSKA_OLIMPIJSKIE$, IO_IO_KONKURENCJA$, IO_IO_REPREZENTACJA$, IO_KANDYDATURA$, IO_KONK_REP$, IO_KONKURENCJA$, IO_KONKURENCJA_MEDALISTA$,
IO_KRAJ$, IO_MEDALISCI$, IO_MEDALISCI_IO$, IO_MIASTO$, IO_MIASTO_KRAJ$, IO_PLEC$, IO_REPREZENTACJA$, IO_SPORT$, IO_MEDALISTA_REPREZENTACJA$