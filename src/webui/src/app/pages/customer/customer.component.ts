import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../services/shared/customer.service";
import {Page} from "../../common/page";
import {Customer} from "../../common/customer.model";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  page = new Page();
  cols=[
    {prop:'id',name:'No'},
    {prop:'customerName',name:'Customer Name'},
    {prop:'customerCode',name:'Customer Code'}
  ]


  rows = [];

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.setPage({offset: 0});
  }

  setPage(pageInfo) {
    this.page.page = pageInfo.offset;
    this.customerService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }
}
