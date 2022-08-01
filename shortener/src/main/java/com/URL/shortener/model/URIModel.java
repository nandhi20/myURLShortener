package com.URL.shortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "URITable")
@Data
@NoArgsConstructor
public class URIModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "shorturl", nullable = false)
	private String shortUrl;

	@Column(name = "longurl", nullable = false)
	private String longUrl;

	public URIModel(String shortenedURL, String longUrl) {
		this.shortUrl = shortenedURL;
		this.longUrl = longUrl;
	}
}
