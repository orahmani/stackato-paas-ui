import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule  } from '@angular/http';
import { PortfolioComponent } from './portfolio.component';
import { AddStockComponent } from './addstock.component';
import { PortfolioService } from './portfolio.service';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent, PortfolioComponent, AddStockComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule
  ],
  providers: [PortfolioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
