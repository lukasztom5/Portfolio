package server;
import dao.*;
import encje.*;

public class ModelRegistry {
public boolean dodaj (Model model){
	ModelDaoImpl mdi=new ModelDaoImpl();
	if(mdi.ModelExists(model)){
	    return false;
	}
	try{
		mdi.save(model);
	}catch(Exception e){
		e.printStackTrace();
	}
	return true;
	
}
}
