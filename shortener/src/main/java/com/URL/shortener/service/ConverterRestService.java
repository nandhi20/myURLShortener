package com.URL.shortener.service;

import org.springframework.stereotype.Component;

import com.URL.shortener.model.URIModel;
import com.URL.shortener.repository.URIRepository;

@Component
public class ConverterRestService {

	public final URIRepository URIRepository;

	public ConverterRestService(URIRepository URIRepository) {
		this.URIRepository = URIRepository;
	}

	@SuppressWarnings("static-access")
	public String generateshortURL(String localURL, String longUrl) {
		Long id = URIRepository.count();
		String uniqueID = Encoder.INSTANCE.createUniqueID(id + 1);
		String baseString = formatLocalURLFromShortener(localURL);
		String shortenedURL = baseString + uniqueID;

		URIModel URIModel = new URIModel(uniqueID, longUrl);
		URIRepository.save(URIModel);

		return shortenedURL;
	}

	private String formatLocalURLFromShortener(String localURL) {
		String[] addressComponents = localURL.split("/");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < addressComponents.length - 1; ++i) {
			sb.append(addressComponents[i]);
		}
		sb.append('/');
		return sb.toString();
	}

	public String getLongURLFromID(String shortUrl) {
		URIModel response = URIRepository.findByShortUrl(shortUrl);
		return response.getLongUrl();
	}

}
