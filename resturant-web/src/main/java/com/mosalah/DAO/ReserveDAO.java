package com.mosalah.DAO;

import java.util.List;

import javax.sql.DataSource;

import com.mosalah.models.reservation;

public interface ReserveDAO {

	
	
	

		List<reservation>getAllreservation( String username );
		void saveReservation(reservation reserve);
		reservation getRserveById(int id);
		int update(reservation reserve);
		int delete(int id);
		
		public void setDataSource(DataSource dataSource);
	
		
		
	
}
