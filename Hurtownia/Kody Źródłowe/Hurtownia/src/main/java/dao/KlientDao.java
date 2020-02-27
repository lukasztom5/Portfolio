package dao;

import java.util.List;

import encje.Klient;

public interface KlientDao {
	public abstract boolean KlientExists(Klient klient);	
	public abstract void save(Klient klient);
	public abstract Klient update(Klient klient);
	public abstract Integer NewIdKlient();
	public abstract Klient findById(int id);
	public abstract List<Klient> findAll();
	public abstract void removeById(int idklient);
	public abstract Klient findbylogin (String login);
	public abstract List<Klient> findbykod(String kod);
	public abstract List<Klient> findbyidp(int idp);
}
