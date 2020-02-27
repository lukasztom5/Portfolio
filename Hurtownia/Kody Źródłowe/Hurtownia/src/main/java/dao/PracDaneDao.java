package dao;

import java.util.List;

import encje.PracDane;

public interface PracDaneDao {
	public abstract List<PracDane> findAll();
	public abstract PracDane findByIdprac(int idprac);
}
