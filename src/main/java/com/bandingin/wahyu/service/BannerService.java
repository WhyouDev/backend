package com.bandingin.wahyu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingin.wahyu.exception.ResourceNotFoundException;
import com.bandingin.wahyu.model.Banner;
import com.bandingin.wahyu.repository.BannerRepository;

@Service("bannerService")
public class BannerService {
	@Autowired
	BannerRepository bannerRepository;
	
	public Iterable<Banner> getAll(){
		return bannerRepository.findAll();
	}
	
	public DataTablesOutput<Banner> listAll(DataTablesInput input){
		return bannerRepository.findAll(input);
	}
	public Banner insert(Banner banner) {
		return bannerRepository.save(banner);
	}
	public Optional<Banner> getById(Integer id){
		return bannerRepository.findById(id);
	}
	public Banner update(Integer id, Banner banner) {
		Banner br = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		br.setTitle(banner.getTitle());
		br.setDescription(banner.getDescription());
		br.setButton_link(banner.getButton_link());
		br.setButton_name(banner.getButton_name());
		Banner update = bannerRepository.save(br);
		return update;
	}
	public ResponseEntity<?> delete(Integer id){
		bannerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
