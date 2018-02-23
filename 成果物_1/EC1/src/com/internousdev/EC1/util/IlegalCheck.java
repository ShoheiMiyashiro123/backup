package com.internousdev.EC1.util;

import java.util.Map;

public class IlegalCheck {

	//"session"にログインしているユーザのデータが存在するかをチェック。
	public static int ilegalCheck(Map<String,Object> session){

		int ret = 0;

		if(session.get("loginUser")!=null){
			ret = 1;
		}

		return ret;

	}
}
