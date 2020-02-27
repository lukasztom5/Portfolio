package p.lodz.pl.dao;


import p.lodz.pl.encje.Administrator;

public interface AdministratorDao {
	public abstract Administrator findById(int id);	
	public abstract boolean AdminExists(Administrator administrator);	
}
