import { Injectable }     from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable }     from 'rxjs/Observable';
import { UserStock } from './userstock';

@Injectable()
export class PortfolioService {

  private serverUrl =  'mng/'; //'https://pmngr.cfapps.io/mng/';
  private portfolioUrl = this.serverUrl + 'getuserstocks/'; 
  private addStockUrl = this.serverUrl + 'addstock/userId/symbol/quantity';
  private delStockUrl = this.serverUrl + 'sellstock/stockId/userId'; 
  
  constructor (private http: Http) {}
  
  getPortfolio(userId): Observable<UserStock[]> {
    return this.http.get(this.portfolioUrl + userId)
                    .map(this.extractData)
                    .catch(this.handleError);
  }
  
  addStock(userId: string, symbol: string, quantity: string): Observable<string> {
  
  	let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    
    var params = { };
    var url = this.addStockUrl.replace('userId', userId).replace('symbol', symbol).replace('quantity', quantity);
    
    return this.http.post(url, params, options)
                    .map(this.extractData)
                    .catch(this.handleError);
  }
  
  sellStock(stockId: string, userId: string): Observable<UserStock[]> {

  	let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    
    var params = { };
    var url = this.delStockUrl.replace('stockId', stockId).replace('userId', userId);
    
    return this.http.get(url).map(this.extractData).catch(this.handleError);
  }
  
  private extractData(res: Response) {
    let body = res.json();
    return body || { };
  }
  
  
  private handleError (error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
