package com.bjsxt.registration.service;

import org.junit.Assert;
import org.junit.Test;

import com.azld.persion.model.Persion;
import com.azld.persion.service.PersionService;
import com.azld.persion.service.impl.PersionServiceImpl;

public class UserManagerTest {

	@Test
	public void testisexists() throws Exception
	{
		PersionService pService = new PersionServiceImpl();
		Persion persion = new Persion();
		persion.setName("f");
		persion.setPassword("f");
		boolean bisexist = pService.IsExistPersion(persion);
		Assert.assertEquals(true, bisexist);
		
	}
	
	
	@Test
	public void testExists() throws Exception {
//		UserManager um = new UserManagerImpl();
//		User u = new User();
//		u.setUsername("a");
//		boolean exists = um.exists(u);
//		Assert.assertEquals(true, exists);
	}

	@Test
	public void testAdd() throws Exception {
//		UserManager um = new UserManagerImpl();
//		User u = new User();
//		u.setUsername("b");
//		u.setPassword("b");
//		boolean exists = um.exists(u);
//		if(!exists) {
//			um.add(u);
//			u.setUsername("b");
//			Assert.assertEquals(true, um.exists(u));
//			
//		} else {
//			Assert.fail("not added");
//		}
		
	}

}
