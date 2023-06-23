package com.mywatch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer")
public class Customer {
	
	@Id
	private String emailId;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String role;
	@Column
	private int inCartNo;
	@Column
	private String inCart;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getInCartNo() {
		return inCartNo;
	}
	public void setInCartNo(int inCartNo) {
		this.inCartNo = inCartNo;
	}
	public String getInCart() {
		return inCart;
	}
	public void setInCart(String inCart) {
		this.inCart = inCart;
	}
	@Override
	public String toString() {
		return "Customer [emailId=" + emailId + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", role=" + role + ", inCartNo=" + inCartNo + ", inCart=" + inCart + "]";
	}
	
	
	
}
