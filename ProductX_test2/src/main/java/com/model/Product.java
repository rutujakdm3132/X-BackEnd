package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {

	@SequenceGenerator(name = "product_seq", initialValue = 2001, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_seq")
	@Column(name = "Product_id")
	private int pId;
	@Column(name = "Product_name")
	private String pCompany;
	private String pModel;
	private float price;
	private String pDescription;
	private String photos;
	private String category;
	private String fullName;
	private long mobile;
	private String city;

	public Product() {
		super();

	}

	public Product(int pId, String pCompany, String pModel, float price, String pDescription, String photos,
			String category, String fullName, long mobile, String city) {
		super();
		this.pId = pId;
		this.pCompany = pCompany;
		this.pModel = pModel;
		this.price = price;
		this.pDescription = pDescription;
		this.photos = photos;
		this.category = category;
		this.fullName = fullName;
		this.mobile = mobile;
		this.city = city;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpCompany() {
		return pCompany;
	}

	public void setpCompany(String pCompany) {
		this.pCompany = pCompany;
	}

	public String getpModel() {
		return pModel;
	}

	public void setpModel(String pModel) {
		this.pModel = pModel;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
