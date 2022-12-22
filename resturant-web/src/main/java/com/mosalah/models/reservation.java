package com.mosalah.models;

public class reservation {

	
	private int id;
	private String customerName;
	private String resturantName;
	private int nOFtables;
    private int nOFchairs;
    private String date;
    private String time;
    
  

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public int getnOFtables() {
		return nOFtables;
	}
	public void setnOFtables(int nOFtables) {
		this.nOFtables = nOFtables;
	}
	public int getnOFchairs() {
		return nOFchairs;
	}
	public void setnOFchairs(int nOFchairs) {
		this.nOFchairs = nOFchairs;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "reservation [id=" + id + ", customerName=" + customerName + ", resturantName=" + resturantName
				+ ", nOFtables=" + nOFtables + ", nOFchairs=" + nOFchairs + ", data=" + date + ", time=" + time + "]";
	}

    
	
	
}
