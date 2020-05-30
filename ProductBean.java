package com.capgemini.inventorymanagementsystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "product_details")
public class ProductBean {
@Id
@GeneratedValue
@Column
private Integer product_id;
@Column
private String product_name;
@Column
private Double product_cost;
@Column
private Integer unit;
@Column
private Date manufacturing_date;
@Column
private Date expiry_date;

public ProductBean() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductBean(Integer product_id, String product_name, Double product_cost, Integer unit, Date manufacturing_date,
		Date expiry_date) {
	super();
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_cost = product_cost;
	this.unit = unit;
	this.manufacturing_date = manufacturing_date;
	this.expiry_date = expiry_date;
}
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public Double getProduct_cost() {
	return product_cost;
}
public void setProduct_cost(Double product_cost) {
	this.product_cost = product_cost;
}
public Integer getUnit() {
	return unit;
}
public void setUnit(Integer unit) {
	this.unit = unit;
}
public Date getManufacturing_date() {
	return manufacturing_date;
}
public void setManufacturing_date(Date manufacturing_date) {
	this.manufacturing_date = manufacturing_date;
}
public Date getExpiry_date() {
	return expiry_date;
}
public void setExpiry_date(Date expiry_date) {
	this.expiry_date = expiry_date;
}
@Override
public String toString() {
	return "ProductBean [product_id=" + product_id + ", product_name=" + product_name + ", product_cost=" + product_cost
			+ ", unit=" + unit + ", manufacturing_date=" + manufacturing_date + ", expiry_date=" + expiry_date + "]";
}





}
