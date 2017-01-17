import { Component } from '@angular/core';
import { PortfolioComponent } from './portfolio.component';
import { AddStockComponent } from './addstock.component';
import './rxjs-operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PAAS Test - Portfolio Application';
}
