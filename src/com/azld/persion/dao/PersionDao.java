package com.azld.persion.dao;

import java.util.List;
import com.azld.persion.model.Persion;

public interface PersionDao {

	public boolean   IsexistPersionWithName(String name);
	public List<Persion>  GetUsers();
	public Persion   GetPersionWithID(int id);
	public boolean save(Persion aPersion) ;
}
