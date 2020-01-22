package com.bandingin.wahyu.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	
		Logger log = LoggerFactory.getLogger(this.getClass().getName());
	    private final Path rootLocationImage = Paths.get("D:\\Images\\");
	    private final Path rootLocationFiles = Paths.get("D:\\Images\\");
	 
	    public void store(MultipartFile file, String url, String hashName) {
	        try {
	        	// Init Check Folder Images for the first time
//	        	Path imageFolderLocation = Paths.get("images");
//	        	if(!Files.exists(imageFolderLocation)) {
//	        		this.initImageFolder(imageFolderLocation);
//	        	}
	        	
	        	Path folderLocation = Paths.get(rootLocationImage + url);
	        	System.out.println(folderLocation.toString());
	        	if(Files.exists(folderLocation)) {
	        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
	        	}else {
	        		this.init(folderLocation);
	        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
	        	}
	        } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	    
	    public void storeFile(MultipartFile file, String url, String hashName) {
	        try {
	        	// Init Check Folder Images for the first time
//	        	Path imageFolderLocation = Paths.get("images");
//	        	if(!Files.exists(imageFolderLocation)) {
//	        		this.initImageFolder(imageFolderLocation);
//	        	}
	        	
	        	Path folderLocation = Paths.get(rootLocationFiles + url);
	        	System.out.println(folderLocation.toString());
	        	if(Files.exists(folderLocation)) {
	        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
	        	}else {
	        		this.init(folderLocation);
	        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
	        	}
	        } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	 
	    public Resource loadFileImage(String folder, String filename) {
	        try {
	            Path file = rootLocationImage.resolve(folder +"/"+ filename);
	            System.out.println(file.toUri());
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            } else {
	                throw new RuntimeException("FAIL!");
	            }
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	    
	    public Resource loadFile(String folder, String filename) {
	        try {
	            Path file = rootLocationFiles.resolve(folder+ "/" + filename);
	            System.out.println(file);
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() || resource.isReadable()) {
	                return resource;
	            } else {
	                throw new RuntimeException("FAIL!");
	            }
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("FAIL!");
	        }
	    }
	 
	    public void deleteAll() {
	        FileSystemUtils.deleteRecursively(rootLocationImage.toFile());
	    }
	 
	    public void init(Path uri) {
	        try {
	        	Files.createDirectory(uri);
	        } catch (IOException e) {
	            throw new RuntimeException("Could not initialize storage!");
	        }
	    }
	    
	    public void initImageFolder(Path uri) {
	    	try {
	        	Files.createDirectory(uri);
	        } catch (IOException e) {
	            throw new RuntimeException("Could not initialize storage!");
	        }
	    }
	 
}
