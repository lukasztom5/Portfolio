package p.lodz.pl.dao;

import java.util.List;

import p.lodz.pl.encje.Klient;


public interface KlientDao {

	public abstract void save(Klient klient);
	public abstract void remove(Klient klient);
	public abstract Klient update(Klient klient);
	public abstract Klient findById(int id);	
	public abstract boolean KlientExists(Klient klient);	
	public abstract Integer NewIdKlient();
	public abstract void removeById(int idklient);
	public abstract List<Klient> findAll();

}