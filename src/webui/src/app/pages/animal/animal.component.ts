import { Component, OnInit } from '@angular/core';
import {AnimalService} from "../../services/shared/animal.service";
import {Page} from "../../common/page";

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.scss']
})
export class AnimalComponent implements OnInit {

  page = new Page();
  rows: [];

  constructor(private animalService: AnimalService) { }

  ngOnInit() {
    this.setPage({offset: 0});
  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.animalService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }
}
