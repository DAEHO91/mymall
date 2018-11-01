package com.test.mymall.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class MemberItemDao {
	
	// MemberItem INNER JOIN item
	public ArrayList<HashMap<String, Object>> getMemberItemList(int memberNo) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		String sql = "";
		/*
		 * SELECT mi.no, mi.order_date, mi.item_no, i.name, i.price 
			FROM member_item mi INNER JOIN item i
			ON mi.item_no = i.no
			WHERE mi.member_no = ?
		 */
		
		while(rs.next()) {
			// MemberItemJoinItem 대신 HashMap 사용
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberItemNo", rs.getInt("mi.no"));
			map.put("memberItemNo", rs.getInt("mi.order_date"));
			map.put("memberItemNo", rs.getInt("mi.item_no"));
			map.put("memberItemNo", rs.getString("i.name"));
			map.put("memberItemNo", rs.getInt("i.price"));
			
		}
		
		return null;
	}
	
	
	public void deleteMemberItem(int no) {
		
	}
	
}
