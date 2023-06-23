package com.mywatch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_company")
public class Company {
	
	@Id
	private int id;
	@Column(nullable=false)
	private int companyId;
	@Column(nullable=false)
	private String companyName;
	@Column()
	private String companyImage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyImage() {
		return companyImage;
	}
	public void setCompanyImage(String companyImage) {
		this.companyImage = companyImage;
	}
	
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyId=" + companyId + ", companyName=" + companyName + ", companyImage="
				+ companyImage + "]";
	}
	
}
