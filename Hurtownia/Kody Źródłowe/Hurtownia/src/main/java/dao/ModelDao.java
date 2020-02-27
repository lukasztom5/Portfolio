package dao;

import java.util.List;

import encje.*;

public interface ModelDao {
	public abstract boolean ModelExists(Model model);	
	public abstract void save(Model model);
	public abstract Integer NewIdModel();
	public abstract Model findById(int id);
	public abstract List<Model> findAll();
	public abstract void removeById(int idmodel);
	public abstract void removeByIdUrzad(int idurzadzenie);
	public abstract List<Model> findByIdurzadz(int idurzadzenie);
	public abstract List<Model> findByurzadznazwa(String nazwa);
	public abstract List<Model> findByurzadznazwa1(String nazwa);

	
}
