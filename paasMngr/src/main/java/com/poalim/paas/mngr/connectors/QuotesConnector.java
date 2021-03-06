package com.poalim.paas.mngr.connectors;

import java.text.MessageFormat;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.poalim.paas.mngr.model.QuotaStock;

public class QuotesConnector {
	
	private static final String quotesServiceUrl = "https://fsr.cfapps.io/stock/{0}";
	
	public static QuotaStock[] getStock(String symbol)
	{ 
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    RestTemplate restTemplate = new RestTemplate();
	    
	    String fullUrl = MessageFormat.format(quotesServiceUrl,symbol);
	    
	    ResponseEntity<QuotaStock[]> result = restTemplate.getForEntity(fullUrl, QuotaStock[].class);
	     
	    return result.getBody();
	}

}
