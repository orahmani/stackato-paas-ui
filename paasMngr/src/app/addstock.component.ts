import { Component, OnInit } from '@angular/core';
import { UserStock } from './userstock';
import { PortfolioService } from './portfolio.service';

@Component({
  selector: 'addstock-comp',
  templateUrl: './addstock.component.html',
})

export class AddStockComponent implements OnInit{
	errorMessage: string;
  	stock: UserStock;
  	mode = 'Observable';

	constructor (private portfolioService: PortfolioService) {}
	
	ngOnInit() { 
		//this.getPortfolio();
	 }
	
	addStock(userId,symbol,quantity) {
	    this.portfolioService.addStock(userId,symbol,quantity)
	                     .subscribe(error =>  this.errorMessage = <any>error);
	}
	
}