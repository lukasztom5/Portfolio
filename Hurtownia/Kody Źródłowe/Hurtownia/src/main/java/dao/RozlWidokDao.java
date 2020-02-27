package dao;

import java.util.List;

import encje.*;

public interface RozlWidokDao {
	public abstract List<RozlWidok> findAll();
	public abstract RozlWidok findByIdrozl(int idrozl);
	
}
