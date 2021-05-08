package com.sapient.league.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientConfiguration implements RequestInterceptor {

	@Value("${feign.apifootball.apiKey}")
	private String apiKey;

	private Logger logger = LoggerFactory.getLogger(FeignClientConfiguration.class);

	@Override
	public void apply(RequestTemplate template) {
		if (logger.isDebugEnabled()) {
			logger.debug("APIkey {}", apiKey);
		}
		template.query("APIkey", apiKey);
		template.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		template.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

	}
}