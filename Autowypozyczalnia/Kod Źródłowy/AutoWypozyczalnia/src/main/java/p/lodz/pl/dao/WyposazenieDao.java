package p.lodz.pl.dao;
import java.util.List;

import p.lodz.pl.encje.Wyposazenie;
public interface WyposazenieDao {
	List<Wyposazenie> findAll();
	Wyposazenie findByCena(int cenaDzien);
	public abstract Wyposazenie findByNazwa(String dodatek);
	public abstract Wyposazenie findById(int idwyposazenie);
}
