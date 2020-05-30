package com.capgemini.inventorymanagementsystem.dto;

public class UserBean {
private Integer user_id;
private String user_type;
private String user_name;
private String password;
private String contact_no;
private String email;
public UserBean() {
	super();
	// TODO Auto-generated constructor stub
}
public UserBean(Integer user_id, String user_type, String user_name, String password, String contact_no, String email) {
	super();
	this.user_id = user_id;
	this.user_type = user_type;
	this.user_name = user_name;
	this.password = password;
	this.contact_no = contact_no;
	this.email = email;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getUser_type() {
	return user_type;
}
public void setUser_type(String user_type) {
	this.user_type = user_type;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact_no() {
	return contact_no;
}
public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "UserBean [user_id=" + user_id + ", user_type=" + user_type + ", user_name=" + user_name + ", password="
			+ password + ", contact_no=" + contact_no + ", email=" + email + "]";
}


}
