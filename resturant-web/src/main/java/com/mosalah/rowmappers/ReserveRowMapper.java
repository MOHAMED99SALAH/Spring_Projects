package com.mosalah.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mosalah.models.reservation;



public class ReserveRowMapper  implements RowMapper<reservation> {

	@Override
	public reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                  reservation reserve = new reservation();
		reserve.setId(rs.getInt("id"));
		reserve.setCustomerName(rs.getString("customerName"));
		reserve.setResturantName(rs.getString("resturantName"));
		reserve.setnOFtables(rs.getInt("nOFtables"));
		reserve.setnOFchairs(rs.getInt("nOFchairs"));
		reserve.setDate(rs.getString("date"));
		reserve.setTime(rs.getString("time"));
		
		return reserve;
		
	}
}