package dao;

import java.util.List;

import encje.Rozliczenie;

public interface RozliczenieDao {

	public abstract void save(Rozliczenie roz);
	public abstract Rozliczenie update(Rozliczenie roz);
	public abstract Rozliczenie findById(int id);
	public abstract Integer NewIdRozliczenie();
	public abstract boolean RozliczenieExists(Rozliczenie roz);
	public abstract List<Rozliczenie> findByPracownika(int idprac);
	public abstract List<Rozliczenie> findAll();
	public abstract void removeByIdPrac(int idprac);
}
