package com.acsy.consultant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.acsy.group.Group;
import com.acsy.history.History;

@Entity
@Table(name="consultants")
public class Consultant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@JoinColumn(name="id")
	private Group group;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consultants")
	//private List<History> histories = new ArrayList<>();
	
	private String password_confirm;
	
	public Consultant(String first_name, String last_name, String phone,String email, String password, String password_confirm) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
/*
	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}
*/

	public String getPasswordConfirm() {
		return password_confirm;
	}

	public void setPasswordConfirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}	
}
