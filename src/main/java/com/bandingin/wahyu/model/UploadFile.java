package com.bandingin.wahyu.model;

public class UploadFile {
	private String fileName;
	private String fileUrl;
	private String fileType;
	private Long size;
	
	public UploadFile(String fileName, String fileUrl, String fileType, Long size) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.fileType = fileType;
		this.size = size;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
}
