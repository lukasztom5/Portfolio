package dao;

import java.util.List;

import encje.*;

public interface PracownikDao {
	public abstract boolean PracownikExists(Pracownik pracownik);	
	public abstract void save(Pracownik pracownik);
	public abstract Pracownik update(Pracownik pracownik);
	public abstract Integer NewIdPracownik();
	public abstract Pracownik findById(int id);
	public abstract List<Pracownik> findAll();
	public abstract void removeById(int idpracownik);
	public abstract List<Pracownik> findByIdAdmin(Administrator id);
	public abstract Pracownik findbylogin (String login);
	public abstract List<Pracownik> findbykod(String kod);
	public abstract List<Pracownik> findwithoutid(int id);
	public abstract List<Pracownik> findtop1();
	public abstract List<Pracownik> findtop1a();
	
}
