package com.URL.shortener.service;

import org.springframework.stereotype.Service;

import com.URL.shortener.model.URIModel;
import com.URL.shortener.repository.URIRepository;

@Service
public class ConverterRestService {

	public final URIRepository URIRepository;
	public final String BASEURL = "http://localhost:8080/";

	public ConverterRestService(URIRepository URIRepository) {
		this.URIRepository = URIRepository;
	}

	@SuppressWarnings("static-access")
	public String generateShortURL(String longUrl) {

		URIModel URIModel = URIRepository.findByLongUrl(longUrl);
		if (null == URIModel) {
			String uniqueID = Encoder.generateCode();
			URIModel = new URIModel(uniqueID, longUrl);
			URIRepository.save(URIModel);
		}
		return BASEURL + URIModel.getShortUrl();
	}

	public String getLongURLFromID(String shortUrl) {
		URIModel response = URIRepository.findByShortUrl(shortUrl);
		return response.getLongUrl();
	}

}
