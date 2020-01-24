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
@Table(name = "websettings")
@EntityListeners(AuditingEntityListener.class)
public class WebSettings implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	@Column(name="stack")
	private Integer stack;
	
	@Column(name = "web_tittle", length = 25)
    @JsonView(DataTablesOutput.View.class)
    private String web_tittle;
	
	@Column(name = "copyright", length = 175)
    @JsonView(DataTablesOutput.View.class)
    private String copyright;
	
	@Column(name = "email", length = 60)
    @JsonView(DataTablesOutput.View.class)
    private String email;
	
	@Column(name = "no_telp", length = 60)
    @JsonView(DataTablesOutput.View.class)
    private String no_telp;
	
	@Column(name = "no_fax", length = 60)
    @JsonView(DataTablesOutput.View.class)
    private String no_fax;
	
	@Column(name = "address", length = 200)
    @JsonView(DataTablesOutput.View.class)
    private String address;
	
	@Column(name = "logo_fb", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String logo_fb;
	
	@Column(name = "logo_twitter", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String logo_twitter;
	
	@Column(name = "logo_instagram", columnDefinition="TEXT")
    @JsonView(DataTablesOutput.View.class)
    private String logo_instagram;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getStack() {
		return stack;
	}

	public void setStack(Integer stack) {
		this.stack = stack;
	}

	public String getWeb_tittle() {
		return web_tittle;
	}

	public void setWeb_tittle(String web_tittle) {
		this.web_tittle = web_tittle;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getNo_fax() {
		return no_fax;
	}

	public void setNo_fax(String no_fax) {
		this.no_fax = no_fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo_fb() {
		return logo_fb;
	}

	public void setLogo_fb(String logo_fb) {
		this.logo_fb = logo_fb;
	}

	public String getLogo_twitter() {
		return logo_twitter;
	}

	public void setLogo_twitter(String logo_twitter) {
		this.logo_twitter = logo_twitter;
	}

	public String getLogo_instagram() {
		return logo_instagram;
	}

	public void setLogo_instagram(String logo_instagram) {
		this.logo_instagram = logo_instagram;
	}
	
}
