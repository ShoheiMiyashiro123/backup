package com.internousdev.EC1.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.EC1.dao.SearchDAO;
import com.internousdev.EC1.dto.SearchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private String keyword;

	private ArrayList<SearchDTO> searchDTOs;

	private ArrayList<SearchDTO> boughts;

	private int bought;

	public Map<String,Object> session;

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		SearchDAO searchDAO = new SearchDAO();
		searchDTOs = searchDAO.itemInfo(keyword);

		if(!session.containsKey("boughts"))
			session.put("boughts", new ArrayList<SearchDTO>());

		SearchDTO searchDTO = null;

		Iterator<SearchDTO> iterator = searchDTOs.iterator();
		/*if(!iterator.hasNext()){
			iterator = null;
		}*/

		//以下でsearchDTOs, bought及びsearchDTOがnullであったり空であったりする場合はどうすべきか？

		boughts = (ArrayList<SearchDTO>)session.get("boughts");
		Iterator<SearchDTO> irr = boughts.iterator();

		//searchDTOないかも。
		while(iterator.hasNext()){
			SearchDTO dto = iterator.next();
			if(bought==dto.getItemId()){
				searchDTO = (SearchDTO)dto.clone();
				while(irr.hasNext()){
					if(bought==irr.next().getItemId()){
						searchDTO=null;
					}
					break;
				}
				break;
			}
		}

		if(searchDTO!=null){
			//session.put("boughts",boughts.add(searchDTO));
			boughts.add(searchDTO);
		}

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

	public ArrayList<SearchDTO> getBoughts() {
		return boughts;
	}

	public void setBoughts(ArrayList<SearchDTO> boughts) {
		this.boughts = boughts;
	}

	public int getBought() {
		return bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
