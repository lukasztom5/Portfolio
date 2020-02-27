package dao;

import java.util.List;

import encje.KlientDane;

public interface KlientDaneDao {
	public abstract List<KlientDane> findAll();
	public abstract KlientDane findByIdklient(int idklient);
}
