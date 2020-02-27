package p.lodz.pl.dao;

import java.util.List;

import p.lodz.pl.encje.AktualneWypozyczenie;


public interface AktualneDao {
	public abstract void save(AktualneWypozyczenie aktualne);
	public abstract AktualneWypozyczenie update(AktualneWypozyczenie aktualne);
	public abstract void remove(AktualneWypozyczenie aktualne);
	public abstract AktualneWypozyczenie findById(int id);
	public abstract void removeById(int idaktualne_wypozyczenie);
	public abstract List<AktualneWypozyczenie> findAll();
	public abstract List<AktualneWypozyczenie> findAutaByKlient(int klientid);
	public abstract List<AktualneWypozyczenie> findKlientByIdAuta(int idauta);
	public abstract Integer NewIdAktualne();
	public abstract AktualneWypozyczenie FindByMaxId();
	public boolean AktualneExists(AktualneWypozyczenie aw);
}
