package p.lodz.pl.serwer;
import p.lodz.pl.dao.AdministratorDaoImpl;
import p.lodz.pl.encje.Administrator;

public class AdminLoginService {
public boolean login(int idadministrator, String login, String haslo){
	AdministratorDaoImpl ado= new AdministratorDaoImpl();
	Administrator admin = ado.findById(idadministrator);
	if(admin!=null && admin.getIdadministrator()==idadministrator && admin.getLogin().equals(login)&&admin.getHaslo().equals(haslo))
		return true;
		else
	return false;
	
}
}
