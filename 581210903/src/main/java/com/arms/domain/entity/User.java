package com.arms.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date updated;
	private String avartar;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@Basic
	@Column(name = "avartar")
	public String getAvartar() {
		return avartar;
	}
	@Basic
	@Column(name = "avartar")
	public void setAvartar(String avatar) {
		this.avartar=avatar ;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Basic
	@Column(name = "updated")
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	 

}
