/**
 * 
 */
package com.azld.persion.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.azld.persion.dao.PersionDao;
import com.azld.persion.model.Persion;
import com.azld.persion.service.PersionService;

/**
 * @author baby
 *
 */

@Component("persionService")
public class PersionServiceImpl implements PersionService {

	private PersionDao	persiondao;
	
	public PersionDao getPersiondao() {
		return persiondao;
	}

	@Resource
	public void setPersiondao(PersionDao apersiondao) {
		this.persiondao = apersiondao;
	}

	/* (non-Javadoc)
	 * @see com.azld.persion.service.PersionService#add(com.azld.persion.model.Persion)
	 */
	@Override
	public void add(Persion apersion) throws Exception {
		// TODO Auto-generated method stub
		persiondao.save(apersion);
	}

	/* (non-Javadoc)
	 * @see com.azld.persion.service.PersionService#IsExistPersion(com.azld.persion.model.Persion)
	 */
	@Override
	public boolean IsExistPersion(Persion apersion) throws Exception {
		// TODO Auto-generated method stub
		return persiondao.IsexistPersionWithName(apersion.getName());
	}

	/* (non-Javadoc)
	 * @see com.azld.persion.service.PersionService#GetPersions()
	 */
	@Override
	public List<Persion> GetPersions() {
		// TODO Auto-generated method stub
		return persiondao.GetUsers();
	}

	/* (non-Javadoc)
	 * @see com.azld.persion.service.PersionService#GetPersionWithID(int)
	 */
	@Override
	public Persion GetPersionWithID(int id) {
		// TODO Auto-generated method stub
		return persiondao.GetPersionWithID(id);
	}

}
