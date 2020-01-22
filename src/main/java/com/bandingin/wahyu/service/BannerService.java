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
	
	
	public Banner insert(Banner banner) {
		return bannerRepository.save(banner);
	}
	
	public Iterable<Banner> getAll(){
		return bannerRepository.findAll();
	}
	
	public DataTablesOutput<Banner> listAjaxBanner(DataTablesInput input){
        return bannerRepository.findAll(input);
    }
	
//	public Banner getByStack(Integer stack) {
//		try {
//			throw new ResourceNotFoundException("Banner Settings", "Stack not found", stack);
//		}catch(Exception s) {
//			return BannerRepository.findByStack(stack);
//		}
//	}
//	
	public Optional<Banner> findById(Integer id){
        return bannerRepository.findById(id);
    }
	
	public Banner update(Integer id, Banner banner) {
		Banner br = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		br.setBanner_name(banner.getBanner_name());
		br.setBanner_image(banner.getBanner_image());
		br.setBanner_link(banner.getBanner_link());
		br.setBanner_desc(banner.getBanner_desc());
		br.setBanner_alt(banner.getBanner_alt());
		Banner update = bannerRepository.save(br);
		return update;
	}
	public ResponseEntity<?> deleteBanner(Integer id){
		Banner banner = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banner", "id", id));
		bannerRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
