package p.lodz.pl.dao;

import java.util.List;

import p.lodz.pl.encje.Auta;

public interface AutaDao {
	public abstract void save(Auta auto);
	public abstract void remove(Auta auto);
	public abstract Auta update(Auta auto);
	public abstract Auta findById(int id);
	public abstract void removeById(int idauta);
	public abstract List<Auta> findAll();
	public abstract Integer NewIdAuto();
	public abstract Auta findAutaByModelMarka(String marka, String model);
	public abstract List<Auta> findWolneAuta();
}
