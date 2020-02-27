package p.lodz.pl.dao;

import java.util.List;

import p.lodz.pl.encje.HistoriaWypozyczenia;


public interface HistoriaDao {
	public abstract void save(HistoriaWypozyczenia historia);
	public abstract HistoriaWypozyczenia update(HistoriaWypozyczenia historia);
	public abstract void remove(HistoriaWypozyczenia historia);
	public abstract HistoriaWypozyczenia findById(int id);
	public abstract void removeById(int idhistoria_wypozyczenia);
	public abstract List<HistoriaWypozyczenia> findAll();
	public abstract List<HistoriaWypozyczenia> findAutaByKlient(int klientid);
	public abstract List<HistoriaWypozyczenia> findKlientByAuta(int autaid);
	public abstract Integer NewIdHistoria();
	public boolean HistoriaExists(HistoriaWypozyczenia hw);
}
