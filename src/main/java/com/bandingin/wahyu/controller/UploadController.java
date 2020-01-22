package com.bandingin.wahyu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bandingin.wahyu.model.UploadFile;
import com.bandingin.wahyu.service.StorageService;
import com.bandingin.wahyu.shared.RandomAlphaNumericService;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UploadController {
	@Autowired
    StorageService storageService; 
	
	@Autowired
	RandomAlphaNumericService randomAlphaNumericService;
 
    List<String> files = new ArrayList<String>();
 
    @PostMapping("/image")
    public UploadFile handleFileImageUpload(@RequestParam("file") MultipartFile file, @RequestParam("url") String url) {
    	
    	try {            
            String filename = file.getOriginalFilename();
            UUID   randomName = UUID.randomUUID();
    		String hashName = randomName + "."+FilenameUtils.getExtension(filename);
    		
            files.add(file.getOriginalFilename());
            //String Name 	= "/"+ url + "/" + hashName;
            String Name 	= url + "/" + hashName;
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            Long fileSize = file.getSize();
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/image/"+ url + "/")
                    .path(hashName)
                    .toUriString();
            storageService.store(file, url, hashName);
            return new UploadFile(Name, fileDownloadUri, fileType, fileSize);
        } catch (Exception e) {
        	System.out.println(e);
            return new UploadFile("", "", "", file.getSize());
        }
    }
    
    @Autowired
    ServletContext servletContext;
    
    @GetMapping("/image/{folder}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable("folder") String folder, @PathVariable("filename") String filename) throws IOException {
        Resource file = storageService.loadFileImage(folder, filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
    
    @PostMapping("/file")
    public UploadFile handleFileUpload(@RequestParam("file") MultipartFile file, 
    									@RequestParam("url") String url) {    	
    	try {            
    		
//    			if(custom_name.equals(null)) {
//    				String filename = file.getOriginalFilename();
//    	            UUID   randomName = UUID.randomUUID();
//    	    		String hashName = randomName + "." + FilenameUtils.getExtension(filename);
//    	    		
//    	            files.add(file.getOriginalFilename());
////    	            String Name 	= "/"+ url + "/" + hashName;
//    	            String Name 	= url + "/" + hashName;
//    	            String fileName = file.getOriginalFilename();
//    	            String fileType = file.getContentType();
//    	            Long fileSize = file.getSize();
//    	            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//    	                    .path("/ape/files/"+ url + "/")
//    	                    .path(hashName)
//    	                    .toUriString();
//    	            storageService.storeFile(file, url, hashName);
//    	            return new UploadFile(Name, fileDownloadUri, fileType, fileSize);
//    			} else {
    				String filename 	= file.getOriginalFilename();
    	            String randomName 	= randomAlphaNumericService.getAlphanumeric(5);
    	    		String hashName 	= FilenameUtils.removeExtension(filename) + "." + FilenameUtils.getExtension(filename);
    	    		
    	            files.add(file.getOriginalFilename());
//    	            String Name 	= "/"+ url + "/" + hashName;
    	            String Name 	= url + "/" + hashName;
    	            String fileName = file.getOriginalFilename();
    	            String fileType = file.getContentType();
    	            Long fileSize = file.getSize();
    	            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
    	                    .path("/api/files/"+ url + "/")
    	                    .path(hashName)
    	                    .toUriString();
    	            storageService.storeFile(file, url, hashName);
    	            return new UploadFile(Name, fileDownloadUri, fileType, fileSize);
//    			}
	    		
	            
	        } catch (Exception e) {
	        	System.out.println(e);
	            return new UploadFile("", "", "", file.getSize());
	        }
    }
    
    @GetMapping("/files/{folder}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFiles(@PathVariable String filename, @PathVariable String folder) {
    	Resource file = storageService.loadFile(folder, filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
