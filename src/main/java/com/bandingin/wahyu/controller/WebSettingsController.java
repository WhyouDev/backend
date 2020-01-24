package com.bandingin.wahyu.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandingin.wahyu.model.WebSettings;
import com.bandingin.wahyu.service.WebSettingsService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class WebSettingsController {
	@Autowired
	WebSettingsService websettingsService;
	
	
	
	@GetMapping("/list/websettings")
    @JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<WebSettings> listAll(@Valid DataTablesInput input){
		return websettingsService.listAll(input);
	}
	
	@GetMapping("/websettings")
	public Iterable<WebSettings> getAll(){
		return websettingsService.getAll();
	}
	
	@GetMapping("/websettings/{id}")
	public Optional<WebSettings> getById(@PathVariable("id") Integer id){
		return websettingsService.getById(id);
	}
	
	@GetMapping("/websetting/{stack}")
	public WebSettings getBystack(@PathVariable("stack") Integer stack) {
		return websettingsService.getByStack(stack);
	}
	
	@PostMapping("/websetting")
	public WebSettings insert (@RequestBody WebSettings websettings) {
		return websettingsService.insert(websettings);
	}
	
	@PutMapping("/websetting/{stack}")
	public WebSettings update(@PathVariable("stack") Integer stack, @RequestBody WebSettings websitesetting) {
		return websettingsService.update(stack, websitesetting);
	}
	
	@DeleteMapping("/websetting/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return websettingsService.delete(id);
	}
	
}
