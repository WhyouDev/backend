package com.bandingin.wahyu.model;

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
public class Banner {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
    private int id;
	
	@Column(name = "title", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String title;
	
	@Column (name= "description", columnDefinition="TEXT")
	@JsonView (DataTablesOutput.View.class)
	private String description;
	
	@Column(name = "button_name", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String button_name;
	
	@Column(name = "button_link", length = 120)
    @JsonView(DataTablesOutput.View.class)
    private String button_link;
	
	@Column(name = "image", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getButton_name() {
		return button_name;
	}

	public void setButton_name(String button_name) {
		this.button_name = button_name;
	}

	public String getButton_link() {
		return button_link;
	}

	public void setButton_link(String button_link) {
		this.button_link = button_link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
