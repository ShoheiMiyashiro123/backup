package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private static String nameSearchDTO = "SearchDTO";

	private String keyword;

	private ArrayList<SearchDTO> searchDTOs;

	public Map<String,Object> session;


	public String execute() throws SQLException{
		SearchDAO searchDAO = new SearchDAO();
		searchDTOs = searchDAO.itemInfo(keyword,nameSearchDTO);

		return SUCCESS;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<SearchDTO> getSearchDTOs() {
		return searchDTOs;
	}

	public void setSearchDTOs(ArrayList<SearchDTO> searchDTOs) {
		this.searchDTOs = searchDTOs;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
