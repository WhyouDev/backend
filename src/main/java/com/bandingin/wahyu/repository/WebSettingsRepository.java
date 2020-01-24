package com.bandingin.wahyu.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.wahyu.model.WebSettings;

public interface WebSettingsRepository extends DataTablesRepository<WebSettings, Integer> {
	WebSettings findByStack(Integer stack);
}
