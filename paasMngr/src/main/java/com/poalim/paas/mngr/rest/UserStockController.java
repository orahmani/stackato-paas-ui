package com.poalim.paas.mngr.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.poalim.paas.mngr.connectors.QuotesConnector;
import com.poalim.paas.mngr.connectors.UserPortfolioConnector;
import com.poalim.paas.mngr.model.QuotaStock;
import com.poalim.paas.mngr.model.UserStock;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mng")
public class UserStockController {
	
	@RequestMapping(value="/addstock/{userId}/{symbol}/{quantity}", method=RequestMethod.POST)
	public ResponseEntity<UserStock[]> create(@PathVariable String userId, @PathVariable String symbol, 
			@PathVariable int quantity, UriComponentsBuilder ucBuilder) {
		//get stock
		QuotaStock[] qStock = QuotesConnector.getStock(symbol);
		
		String res = UserPortfolioConnector.addStock(new UserStock(userId, qStock[0].getName(), symbol, quantity, qStock[0].getLastTradeValue() * quantity));
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path(res).buildAndExpand().toUri());
	    return getUserStocks(userId, ucBuilder);
	}
	
	@RequestMapping(value="/getuserstocks/{userId}", method=RequestMethod.GET)
	public ResponseEntity<UserStock[]> getUserStocks(@PathVariable String userId, UriComponentsBuilder ucBuilder) {
		//get stock
		UserStock[] qStock = UserPortfolioConnector.findUserStocks(userId);

		return new ResponseEntity<UserStock[]>(qStock, HttpStatus.OK);
	}
	
	@RequestMapping(value="/sellstock/{stockId}/{userId}", method=RequestMethod.GET)
	public ResponseEntity<UserStock[]> sellUserStock(@PathVariable String stockId, @PathVariable String userId, UriComponentsBuilder ucBuilder) {
		//sell stock
		String res = UserPortfolioConnector.sellUserStocks(stockId);
		
	    return getUserStocks(userId, ucBuilder);
	}
	
}