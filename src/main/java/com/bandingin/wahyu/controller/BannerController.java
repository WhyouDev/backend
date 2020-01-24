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

import com.bandingin.wahyu.model.Banner;
import com.bandingin.wahyu.service.BannerService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BannerController {
	
	@Autowired
	BannerService bannerService;
	
	@GetMapping("/banner")
	public Iterable<Banner> getAll(){
        return bannerService.getAll();
    }
	
	@JsonView(DataTablesOutput.View.class)
    @GetMapping("/list/banner")
    public DataTablesOutput<Banner> getBanners(@Valid DataTablesInput input) {
        return bannerService.listAjaxBanner(input);
    }
 
    @GetMapping("/banner/{id}")
    public Optional<Banner> getById(@PathVariable("id") Integer id){
        return bannerService.findById(id);
    }
    
    @GetMapping("/banners/{stack}")
    public Banner getByStack(@PathVariable("stack") Integer stack){
        return bannerService.getByStack(stack);
    }
   
    @PostMapping("/banner")
    public Banner addBanner(@RequestBody Banner banner) {
        return bannerService.insert(banner);
    }
   
    @PutMapping("/banner/{stack}")
    public Banner updateBanner(@PathVariable("stack") Integer stack, @RequestBody Banner banner) {
        return bannerService.update(stack, banner);
    }
   
    @DeleteMapping("/banner/{id}")
    public ResponseEntity<?> deleteBanner(@PathVariable Integer id){
        return bannerService.deleteBanner(id);
    }
}
