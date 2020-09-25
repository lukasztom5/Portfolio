select * from f1_kontynent
alter table f1_kontynent alter column Id_kontynent int not null 
alter table f1_kontynent add primary key(Id_kontynent)
---------------------------------------------------------------------
select * from f1_kraj
alter table f1_kraj alter column Id_kraj int not null 
alter table f1_kraj add primary key(id_kraj)
alter table f1_kraj alter column Id_kontynent int
alter table f1_kraj alter column Id_status_gp int
alter table f1_kraj alter column Id_status_konstr int
alter table f1_kraj alter column Id_status_kierowca int
alter table f1_kraj add foreign key (id_kontynent) references f1_kontynent(id_kontynent)
alter table f1_kraj add foreign key (id_status_gp) references f1_status(Id_status)
alter table f1_kraj add foreign key (id_status_konstr) references f1_status(Id_status)
alter table f1_kraj add foreign key (id_status_kierowca) references f1_status(Id_status)
---------------------------------------------------------------------
select * from f1_status
alter table f1_status alter column Id_status int not null 
alter table f1_status add primary key(Id_status)
---------------------------------------------------------------------
select * from f1_tory
alter table f1_tory alter column Id_tor int not null 
alter table f1_tory add primary key(Id_tor)
alter table f1_tory alter column Id_kraj int
alter table f1_tory alter column Id_status int
alter table f1_tory add foreign key (id_kraj) references f1_kraj(Id_kraj)
alter table f1_tory add foreign key (id_status) references f1_status(Id_status)
---------------------------------------------------------------------
select * from f1_grandprix
alter table f1_grandprix alter column Id_GP int not null 
alter table f1_grandprix add primary key(Id_GP)
alter table f1_grandprix alter column Id_status int
alter table f1_grandprix add foreign key (id_status) references f1_status(Id_status)
----------------------------------------------------------------------
select * from f1_rok
alter table f1_rok alter column Id_rok int not null 
alter table f1_rok add primary key(Id_rok)
alter table f1_rok alter column rok int
-----------------------------------------------------------------------
select * from f1_silnik
alter table f1_silnik alter column Id_silnik int not null 
alter table f1_silnik add primary key(Id_silnik)
alter table f1_silnik alter column id_status int
alter table f1_silnik add foreign key (id_status) references f1_status(Id_status)
------------------------------------------------------------------------
select * from f1_konstruktorzy
alter table f1_konstruktorzy alter column Id_konstruktor int not null 
alter table f1_konstruktorzy add primary key(Id_konstruktor)
alter table f1_konstruktorzy alter column mistrzostwo int
alter table f1_konstruktorzy alter column wygrane int
alter table f1_konstruktorzy alter column podium int
alter table f1_konstruktorzy alter column pole_position int
alter table f1_konstruktorzy alter column id_status int
alter table f1_konstruktorzy alter column punkty decimal(16,2)
alter table f1_konstruktorzy add foreign key (id_status) references f1_status(Id_status)
----------------------------------------------------------------
select * from f1_konstruktor_kraj_silnik_rok
alter table f1_konstruktor_kraj_silnik_rok alter column Id_kksr int not null 
alter table f1_konstruktor_kraj_silnik_rok add primary key(Id_kksr)
alter table f1_konstruktor_kraj_silnik_rok alter column Id_konstruktor int 
alter table f1_konstruktor_kraj_silnik_rok alter column Id_silnik int 
alter table f1_konstruktor_kraj_silnik_rok alter column Id_kraj int 
alter table f1_konstruktor_kraj_silnik_rok alter column Id_rok int 
alter table f1_konstruktor_kraj_silnik_rok alter column rok int 
alter table f1_konstruktor_kraj_silnik_rok alter column mistrzostwo int 
alter table f1_konstruktor_kraj_silnik_rok alter column miejsce int 
alter table f1_konstruktor_kraj_silnik_rok alter column wygrane int 
alter table f1_konstruktor_kraj_silnik_rok alter column podium int 
alter table f1_konstruktor_kraj_silnik_rok alter column punkty decimal(16,2)
alter table f1_konstruktor_kraj_silnik_rok add foreign key (id_konstruktor) references f1_konstruktorzy(Id_konstruktor)
alter table f1_konstruktor_kraj_silnik_rok add foreign key (id_silnik) references f1_silnik(Id_silnik)
alter table f1_konstruktor_kraj_silnik_rok add foreign key (id_kraj) references f1_kraj(Id_kraj)
alter table f1_konstruktor_kraj_silnik_rok add foreign key (id_rok) references f1_rok(Id_rok)
--------------------------------------------------------------------------------
select * from f1_kierowcy
alter table f1_kierowcy alter column Id_kierowca int not null 
alter table f1_kierowcy add primary key(Id_kierowca)
alter table f1_kierowcy alter column id_status int 
alter table f1_kierowcy alter column mistrzostwo int 
alter table f1_kierowcy alter column zwyciestwo int 
alter table f1_kierowcy alter column podium int 
alter table f1_kierowcy alter column punkty decimal(16,2)
alter table f1_kierowcy alter column pole_position int
alter table f1_kierowcy add foreign key (id_status) references f1_status(Id_status)
-------------------------------------------------------------------------------
select * from F1_GRANDPRIX_TORY
alter table F1_GRANDPRIX_TORY alter column Id_GT int not null 
alter table F1_GRANDPRIX_TORY add primary key(Id_GT)
alter table F1_GRANDPRIX_TORY alter column id_GRANDPRIX int 
alter table F1_GRANDPRIX_TORY alter column ID_TOR int 
alter table F1_GRANDPRIX_TORY alter column NUMER_WYSCIGU int 
alter table F1_GRANDPRIX_TORY add foreign key (id_GRANDPRIX) references f1_grandprix(Id_gp)
alter table F1_GRANDPRIX_TORY add foreign key (id_tor) references f1_tory(Id_tor)
-------------------------------------------------------------------------------
select * from F1_wynik
alter table F1_wynik alter column Id_wynik int not null 
alter table F1_wynik add primary key(Id_wynik)
alter table F1_wynik alter column id_gt int 
alter table F1_wynik alter column id_rok int 
alter table F1_wynik alter column id_kkr int 
alter table F1_wynik alter column id_kksr int 
alter table F1_wynik alter column numer_wyscigu int 
alter table F1_wynik alter column rok int 
alter table F1_wynik alter column miejsce int 
alter table F1_wynik alter column status_wyscigu int 
alter table F1_wynik alter column punkty decimal(16,2)
alter table F1_wynik add foreign key (id_gt) references f1_grandprix_tory(Id_gt)
alter table F1_wynik add foreign key (id_rok) references f1_rok(Id_rok)
alter table F1_wynik add foreign key (id_kkr) references f1_kierowca_kraj_rok(Id_kkr)
alter table F1_wynik add foreign key (id_kksr) references f1_konstruktor_kraj_silnik_rok(Id_kksr)
----------------------------------------------------------------
select * from F1_KIEROWCA_KRAJ_ROK
alter table F1_KIEROWCA_KRAJ_ROK alter column Id_kkr int not null 
alter table F1_KIEROWCA_KRAJ_ROK add primary key(Id_kkr)
alter table F1_KIEROWCA_KRAJ_ROK alter column id_kraj int 
alter table F1_KIEROWCA_KRAJ_ROK alter column id_rok int 
alter table F1_KIEROWCA_KRAJ_ROK alter column rok int 
alter table F1_KIEROWCA_KRAJ_ROK alter column miejsce int 
alter table F1_KIEROWCA_KRAJ_ROK alter column wygrane int 
alter table F1_KIEROWCA_KRAJ_ROK alter column podium int 
alter table F1_KIEROWCA_KRAJ_ROK add foreign key (id_kraj) references f1_kraj(Id_kraj)
alter table F1_KIEROWCA_KRAJ_ROK add foreign key (id_rok) references f1_rok(Id_rok)
alter table F1_KIEROWCA_KRAJ_ROK add foreign key (id_status) references f1_status(Id_status)