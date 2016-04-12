package com.azld.persion.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.azld.persion.model.Persion;
import com.azld.persion.model.vo.PersionCreateInfo;
import com.azld.persion.service.PersionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("persionaction")
@Scope("prototype")
public class PersionAction extends ActionSupport implements ModelDriven {

	private PersionCreateInfo persioninfoCreateInfo = new PersionCreateInfo();
	private PersionService	  persionsevice;
	private List<Persion>     persions;
	private Persion			  persion;

	public PersionAction()
	{
		System.out.println("persion action created");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(persioninfoCreateInfo.getUsername());
		Persion apersion = new Persion();
		apersion.setName(persioninfoCreateInfo.getUsername());
		apersion.setPassword(persioninfoCreateInfo.getPassword());
		apersion.setTitle("a");
		
		if(persionsevice.IsExistPersion(apersion)) 
		{
			return "fail";
		}
		persionsevice.add(apersion);;
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return persioninfoCreateInfo;
	}

	public String getpersions()
	{
		persions = persionsevice.GetPersions();
		return "list";
	}
	
	public String loadAnPersionString()
	{
		persion = persionsevice.GetPersionWithID(persioninfoCreateInfo.getId());
		return "load";
	}
	
	public PersionCreateInfo getPersioninfoCreateInfo() {
		return persioninfoCreateInfo;
	}

	public void setPersioninfoCreateInfo(PersionCreateInfo persioninfoCreateInfo) {
		this.persioninfoCreateInfo = persioninfoCreateInfo;
	}

	public Persion getPersion() {
		return persion;
	}

	public void setPersion(Persion persion) {
		this.persion = persion;
	}

	public PersionService getPersionsevice() {
		System.out.println("getPersionsevice");
		return persionsevice;
	}

	@Resource
	public void setPersionsevice(PersionService persionsevice) {
		System.out.println("setPersionsevice");
		this.persionsevice = persionsevice;
	}

	public List<Persion> getPersions() {
		return persions;
	}

	public void setPersions(List<Persion> persions) {
		this.persions = persions;
	}

	
	
	
	
}
