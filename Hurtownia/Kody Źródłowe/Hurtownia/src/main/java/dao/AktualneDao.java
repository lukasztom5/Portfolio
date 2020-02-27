package dao;

import java.util.List;

import encje.*;

public interface AktualneDao {
	public abstract boolean AktualneExists(AktualneZamowienia az);	
	public abstract void save(AktualneZamowienia az);
	public abstract Integer NewIdAktualne();
	public abstract AktualneZamowienia findById(int id);
	public abstract List<AktualneZamowienia> findAll();
	public abstract void removeById(int idaz);
	public abstract void removeByIdkc(int idk, int idc);
	public abstract List<AktualneZamowienia> findByIdkl(int idklient);
	public abstract List<AktualneZamowienia> findByIpr(int idpracownik);
	public abstract List<AktualneZamowienia> findByIcz(int idczesc);
	public abstract AktualneZamowienia update(AktualneZamowienia c);
	public abstract List<AktualneZamowienia> findBykcd(int idklient,int idczesc);
	public abstract List<AktualneZamowienia> findBykcdp(int idklient,int idczesc, int idpracownik, int ilosc);
	public abstract void removeById1(int idaz);
	public abstract List<AktualneZamowienia> findByIk(int idkosz);
}
