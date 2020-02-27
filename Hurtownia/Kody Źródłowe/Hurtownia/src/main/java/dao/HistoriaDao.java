package dao;

import java.util.List;

import encje.*;

public interface HistoriaDao {
	public abstract boolean HistoriaExists(HistoriaZamowienia hz);	
	public abstract void save(HistoriaZamowienia hz);
	public abstract Integer NewIdHistoria();
	public abstract HistoriaZamowienia findById(int id);
	public abstract List<HistoriaZamowienia> findAll();
	public abstract void removeById(int idhz);
	public abstract List<HistoriaZamowienia> findByIdkl(int idklient);
	public abstract List<HistoriaZamowienia> findByIpr(int idpracownik);
	public abstract List<HistoriaZamowienia> findByIcz(int idczesc);
	public abstract HistoriaZamowienia update(HistoriaZamowienia c);
	public abstract List<HistoriaZamowienia> findhi();
	public abstract List<HistoriaZamowienia> findhi1(int ic);
	public abstract List<HistoriaZamowienia> findhi2(int im);
	public abstract List<HistoriaZamowienia> findhi3(int im, int m);
	public abstract List<HistoriaZamowienia> findhi4(int im, int m);
}
