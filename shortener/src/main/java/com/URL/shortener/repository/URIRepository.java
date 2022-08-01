package com.URL.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.URL.shortener.model.URIModel;

public interface URIRepository extends JpaRepository<URIModel, Long> {
	URIModel findByShortUrl(String shortUrl);
}
