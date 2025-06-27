package com.nurserymitra.Entity;


import jakarta.persistence.*;

@Entity
public class Attendance 
{
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String staff_name;
	private String date;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
