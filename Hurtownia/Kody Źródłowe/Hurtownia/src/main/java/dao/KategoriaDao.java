package dao;

import java.util.List;

import encje.*;

public interface KategoriaDao {
	public abstract boolean KategoriaExists(Kategoria kategoria);	
	public abstract void save(Kategoria kategoria);
	public abstract Integer NewIdKategoria();
	public abstract Kategoria findById(int id);
	public abstract List<Kategoria> findAll();
	public abstract void removeById(int idkategoria);
	public abstract void removeByIdUrzad(int idurzadzenie);
	public abstract List<Kategoria> findByIdurzadz(int idurzadzenie);
	public abstract List<Kategoria> findByurzadznazwa(String nazwa);
	public abstract List<Kategoria> findBymodelnazwa(String nazwa);
	public abstract Kategoria findBynazwa(String nazwa);
}
