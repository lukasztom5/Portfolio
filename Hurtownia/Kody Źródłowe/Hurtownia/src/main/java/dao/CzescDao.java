package dao;

import java.util.List;

import encje.*;

public interface CzescDao {
	public abstract boolean CzescExists(Czesc czesc);	
	public abstract void save(Czesc czesc);
	public abstract Integer NewIdCzesc();
	public abstract Czesc findById(int id);
	public abstract List<Czesc> findAll();
	public abstract void removeById(int idczesc);
	public abstract List<Czesc> findByIdkat(int idkategoria);
	public abstract List<Czesc> findByIdmod(int idmodel);
	public abstract Czesc update(Czesc c);
	public abstract List<Czesc> findBykat(String idkategoria);
	public abstract List<Czesc> findBymodel(String idmodel);
	public abstract List<Czesc> findtop();
	
	
}
