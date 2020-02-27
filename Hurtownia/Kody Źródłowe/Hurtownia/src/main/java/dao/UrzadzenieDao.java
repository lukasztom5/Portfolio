package dao;

import java.util.List;

import encje.*;

public interface UrzadzenieDao {
	public abstract List<Urzadzenie> findAll();
	public abstract boolean UrzadzenieExists(Urzadzenie urzadzenie);	
	public abstract void save(Urzadzenie urzadzenie);
	public abstract Integer NewIdUrzadz();
	public abstract Urzadzenie findById(int id);
	public abstract void removeById(int idurzadz);
	public abstract Urzadzenie findBynazwa(String urzadzenie);
	
}
