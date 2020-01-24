package com.bandingin.wahyu.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bandingin.wahyu.exception.ResourceNotFoundException;
import com.bandingin.wahyu.model.WebSettings;
import com.bandingin.wahyu.repository.WebSettingsRepository;
import com.fasterxml.jackson.annotation.JsonView;

@Service("websettingService")
public class WebSettingsService {
	@Autowired
	WebSettingsRepository webSettingsRepository;
	
	public Iterable<WebSettings> getAll(){
		return webSettingsRepository.findAll();
	}
	
	public  DataTablesOutput<WebSettings> listAll(DataTablesInput input){
		return webSettingsRepository.findAll(input);
	}
	
	public WebSettings getByStack(Integer stack) {
		try {
			throw new ResourceNotFoundException("Web Settings", "stack not found", stack);
		}catch(Exception e) {
			return webSettingsRepository.findByStack(stack);
		}
	}
	
	public WebSettings insert(WebSettings websitesetting) {
		return webSettingsRepository.save(websitesetting);
	}
	
	public Optional<WebSettings> getById(Integer id){
		return webSettingsRepository.findById(id);
	}
	
	public WebSettings update(Integer code, WebSettings websettings) {
		WebSettings ws = webSettingsRepository.findByStack(code);
		if(ws != null) {
		ws.setWeb_tittle(websettings.getWeb_tittle());
		ws.setLogo_fb(websettings.getLogo_fb());
		ws.setLogo_twitter(websettings.getLogo_twitter());
		ws.setLogo_instagram(websettings.getLogo_instagram());
		ws.setCopyright(websettings.getCopyright());
		ws.setNo_telp(websettings.getNo_telp());
		ws.setNo_fax(websettings.getNo_fax());
		ws.setEmail(websettings.getEmail());
		ws.setAddress(websettings.getAddress());
		ws.setStack(websettings.getStack());
		WebSettings update = webSettingsRepository.save(ws);
		return update;
		}else {
			throw new ResourceNotFoundException("WebsiteSetting", "Stack not found", ws.getStack());
		}
	}
	public ResponseEntity<?> delete(Integer id){
		webSettingsRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
