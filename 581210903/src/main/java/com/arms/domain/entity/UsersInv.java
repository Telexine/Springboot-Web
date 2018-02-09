package com.arms.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class UsersInv {
	private int id;
	private int itemid;
	
	
	private User user;
	private Integer userId;
	
	@Basic
	@Column(name = "user_id")
	public Integer getUserId() {
	return userId;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	
	@Id
	@GeneratedValue
	@Basic
	@Column(name = "id")
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	@Basic
	@Column(name = "uid")
	public Integer getuid() {
	return userId;
	}
 
	
	@Basic
	@Column(name = "uid")
	public void setUid(int uid) {
		this.userId = uid;
	}
 
	
	@Basic
	@Column(name = "itemid")
	public int getItemid() {
		return itemid;
	}
 
	@Basic
	@Column(name = "itemid")
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	
	
	
	
	
}
