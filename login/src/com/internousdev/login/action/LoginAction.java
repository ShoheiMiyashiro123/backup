package com.internousdev.login.action;

public class LoginAction {
	private String name;
	private String password;
	private Map<String,Object> session;

	public String execute() throws SQLException{

		private String ret = ERROR;

		private LoginDAO dao = new LoginDAO();
		private LoginDTO dto = dao.select(name,password);

		if(name==dto.getName()&&password==dto.getPassword()){
			ret = SUCCESS;
		}

		session = ["name":dto.getName()];
	}
}
