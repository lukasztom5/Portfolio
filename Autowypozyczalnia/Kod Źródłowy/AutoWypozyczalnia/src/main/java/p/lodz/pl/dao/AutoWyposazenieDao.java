package p.lodz.pl.dao;

import java.util.List;
import p.lodz.pl.encje.AutoWyposazenie;

public interface AutoWyposazenieDao {
	public abstract void remove(AutoWyposazenie aw);
	public abstract void save(AutoWyposazenie aw);
	public abstract List<AutoWyposazenie> findWypByIdAuta(int idauta);
	public abstract List<AutoWyposazenie> findAutoByWyp(int idwyposazenie);
	public abstract List<AutoWyposazenie> findAll();
}

