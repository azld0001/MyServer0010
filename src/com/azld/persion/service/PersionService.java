package com.azld.persion.service;

import java.util.List;

import com.azld.persion.model.Persion;

public interface PersionService {
	
	public abstract void add(Persion apersion) throws Exception;
	public abstract boolean  IsExistPersion(Persion persion) throws Exception;
	
	public List<Persion> GetPersions();
	public Persion GetPersionWithID(int id);
	
}
