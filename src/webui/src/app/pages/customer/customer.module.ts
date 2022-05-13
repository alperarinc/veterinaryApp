import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer.component';
import {CustomerRoutingModule} from "./customer.routing.module";
import {CustomerService} from "../../services/shared/customer.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

@NgModule({
  declarations: [CustomerComponent],
  providers:[CustomerService],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    NgxDatatableModule
  ],

})
export class CustomerModule { }
