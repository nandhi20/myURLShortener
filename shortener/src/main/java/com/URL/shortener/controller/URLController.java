package com.URL.shortener.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.URL.shortener.service.ConverterRestService;
import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class URLController {

	public final ConverterRestService converterRestService;

	public URLController(ConverterRestService converterRestService) {
		this.converterRestService = converterRestService;
	}

	@RequestMapping(value = "/shortenURL", method = RequestMethod.POST, consumes = { "application/json" })
	public String shortenUrl(@RequestBody @Valid URIRequest shortenRequest, HttpServletRequest request) {

		String shortenedUrl = converterRestService.generateshortURL(request.getRequestURL().toString(),
				shortenRequest.getUrl());

		return shortenedUrl;

	}

	@RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
	public RedirectView redirectUrl(@PathVariable String shortUrl, HttpServletRequest request,
			HttpServletResponse response) {
		String redirectUrlString = converterRestService.getLongURLFromID(shortUrl);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(redirectUrlString);
		return redirectView;
	}

}

class URIRequest {

	@JsonProperty("url")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
