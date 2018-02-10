package com.arms.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User {

	private int id;
	private String nickname;
	private String username;
	private String password;
	private Date created;
	private Date updated;
	
	public String avartar;
	
	private List<UsersInv> userInvList;

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
	@Column(name = "nickname")
	public String getNickname() {
		return nickname;
	}
	
	@Basic
	@Column(name = "avartar")
	public String getAvartar() {
		return avartar;
	}
	@Basic
	@Column(name = "avartar")
	public void setAvartar(String avartar) {
		this.avartar=avartar ;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Basic
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	 
	// Relation
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	public List<UsersInv> getuserInvList() {
		return userInvList;
	}

	public void setUserInvList(List<UsersInv> userInvList) {
		this.userInvList = userInvList;
	}

}
