package com.arms.domain.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Item {

	private int id;
	private String name;
	private int star;
	private String desc;
	private String imgurl;
	
	@OneToOne(mappedBy = "itemid") 
	private UsersInv itemid; 
	
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
	@Column(name = "name")
	public void setName(String name) {
		this.name=name ;
	}
	
	@Basic
	@Column(name = "star")
	public int getStar() {
		return star;
	}
	@Basic
	@Column(name = "star")
	public void setStar(int star) {
		this.star=star ;
	}
	
	@Basic
	@Column(name = "desc")
	public String getDesc() {
		return desc;
	}
	@Basic
	@Column(name = "desc")
	public void setDesc(String desc) {
		this.desc=desc ;
	}
	
	@Basic
	@Column(name = "imgurl")
	public String getImgurl() {
		return imgurl;
	}
	@Basic
	@Column(name = "imgurl")
	public void setImgurl(String imgurl) {
		this.imgurl=imgurl ;
	}
	
	// Relation
	
	 
}
