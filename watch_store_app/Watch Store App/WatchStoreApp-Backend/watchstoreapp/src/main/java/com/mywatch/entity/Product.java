package com.mywatch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product {
	
	@Id
	private int id;
	@Column(nullable=false)
	private int companyId;
	@Column
	private String productImage;
	@Column
	private String productCompany;
	@Column
	private int productPrice;
	public String getProductCompany() {
		return productCompany;
	}
	public void setProductCompany(String productCompany) {
		this.productCompany = productCompany;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Column
	private String productName;
	@Column
	private String productDescription;
	@Column
	private int isLatestProduct;
	@Column
	private int isSmartWatchProduct;
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
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getIsLatestProduct() {
		return isLatestProduct;
	}
	public void setIsLatestProduct(int isLatestProduct) {
		this.isLatestProduct = isLatestProduct;
	}
	public int getIsSmartWatchProduct() {
		return isSmartWatchProduct;
	}
	public void setIsSmartWatchProduct(int isSmartWatchProduct) {
		this.isSmartWatchProduct = isSmartWatchProduct;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", companyId=" + companyId + ", productImage=" + productImage + ", productName="
				+ productName + ", productDescription=" + productDescription + ", isLatestProduct=" + isLatestProduct
				+ ", isSmartWatchProduct=" + isSmartWatchProduct + "]";
	}
	
	

}
