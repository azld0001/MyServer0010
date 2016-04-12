package com.azld.persion.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.hql.ast.tree.FromClause;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.azld.persion.dao.PersionDao;
import com.azld.persion.model.Persion;

@Component("persionDao")
public class PersionDaoImpl implements PersionDao {

	private HibernateTemplate hibernateTemplate; 
	
	@Override
	public boolean IsexistPersionWithName(String name) {
		// TODO Auto-generated method stub
		List<Persion> persions = this.hibernateTemplate.find("from persion where name = '"+name+"'");
//		List<Persion> persions = this.hibernateTemplate.find("from persion");
		if (persions != null)
		{
			if (persions.size() > 0)
			{
				return true;
			}
		}		
		return false;
	}

	@Override
	public List<Persion> GetUsers() 
	{
		return (List<Persion>)this.hibernateTemplate.find("from persion");
	}

	@Override
	public Persion GetPersionWithID(int id) 
	{
		return (Persion) this.hibernateTemplate.load(Persion.class, id);
	}

	@Override
	public boolean save(Persion aPersion) 
	{
		hibernateTemplate.save(aPersion);
		return true;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	
}
