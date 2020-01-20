package com.bandingin.wahyu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(DataTablesOutput.View.class)
	private int id;
	
	@Column(name="product_name", length = 20)
	@JsonView(DataTablesOutput.View.class)
	private String product_name;
	
	@Column(name="product_price", length = 11)
	@JsonView(DataTablesOutput.View.class)
	private String product_price;
	
	@Column(name="product_detail", length=200)
	@JsonView(DataTablesOutput.View.class)
	private String product_detail;
	
	@Column(name="update_by", length=50)
	@JsonView(DataTablesOutput.View.class)
	private String update_by;
	
	@Column(name = "image", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String image;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyy-MM-dd")
	@LastModifiedDate
	private Date product_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getProduct_date() {
		return product_date;
	}

	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
}
