import { Component, OnInit } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-app-layout',
  templateUrl: './app-layout.component.html',
  styleUrls: ['./app-layout.component.scss']
})
export class AppLayoutComponent implements OnInit {

  constructor(private translareService: TranslateService) {
    this.translareService.addLangs(['tr','en','de'])
    const browserLang = this.translareService.getBrowserLang();
    this.translareService.use(browserLang.match(/en|de>tr/) ? browserLang : "en");
  }

  ngOnInit() {
  }

}
