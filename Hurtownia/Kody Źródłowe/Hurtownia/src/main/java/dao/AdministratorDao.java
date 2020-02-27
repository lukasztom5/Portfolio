package dao;

import java.util.List;

import encje.Administrator;

public interface AdministratorDao {
	public abstract Administrator findById(int id);	
	public abstract Administrator findByIdadmin(int id);	
	public abstract List<Administrator> findAll();
	public abstract Administrator findByIdadminP(Administrator a);	
	public abstract Administrator findbylogin (String login);
	
	
}
