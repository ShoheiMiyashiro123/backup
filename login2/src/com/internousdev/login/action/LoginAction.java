package com.internousdev.login.action;

import java.util.Map;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;

public class LoginAction extends ActionSupport implements SessionAware{
	private String name;
	private String password;
	private Map<String,Object> session;

	public String execute(){

		String ret = ERROR;

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = dao.select(name,password);

		if(name.equals(dto.getName())){
			if(password.equals(dto.getPassword())){
				ret = SUCCESS;
			}
		}

		session.put("name",dto.getName());

	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}
}
