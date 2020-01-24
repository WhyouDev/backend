package com.bandingin.wahyu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name ="banner")
@EntityListeners(AuditingEntityListener.class)
public class Banner implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name="stack")
	@JsonView(DataTablesOutput.View.class)
	private Integer stack;
	
	@Column(name = "banner_name", length = 200)
    @JsonView(DataTablesOutput.View.class)
    private String banner_name;
	
	@Column(name = "banner_image", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String banner_image;
	
	@Column(name = "banner_link", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String banner_link;
	
	@Column (name= "banner_desc", columnDefinition="TEXT")
	@JsonView (DataTablesOutput.View.class)
	private String banner_desc;
	
	@Column(name = "banner_alt", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String banner_alt;
	
	

	public Integer getStack() {
		return stack;
	}

	public void setStack(Integer stack) {
		this.stack = stack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}

	public String getBanner_image() {
		return banner_image;
	}

	public void setBanner_image(String banner_image) {
		this.banner_image = banner_image;
	}

	public String getBanner_link() {
		return banner_link;
	}

	public void setBanner_link(String banner_link) {
		this.banner_link = banner_link;
	}

	public String getBanner_desc() {
		return banner_desc;
	}

	public void setBanner_desc(String banner_desc) {
		this.banner_desc = banner_desc;
	}

	public String getBanner_alt() {
		return banner_alt;
	}

	public void setBanner_alt(String banner_alt) {
		this.banner_alt = banner_alt;
	}
}
