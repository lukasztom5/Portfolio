package dao;

import java.util.List;

import encje.*;

public interface KoszykDao {
	public abstract boolean KoszykExists(Koszyk koszyk);	
	public abstract void save(Koszyk koszyk);
	public abstract Integer NewIdKoszyk();
	public abstract void removeById(int idkoszyk);
	public abstract List<Koszyk> findByIdkl(int idklient);
	public abstract Koszyk findById(int id);
	
	
}
