package com.internousdev.EC1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

	public String utilDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");

		return simpleDateFormat.format(date);
	}
}
