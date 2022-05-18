import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer.component';
import {CustomerRoutingModule} from "./customer.routing.module";
import {CustomerService} from "../../services/shared/customer.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {SharedModule} from "../../shared/shared.module";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [CustomerComponent],
  providers:[CustomerService],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    NgxDatatableModule,
    SharedModule,
    ReactiveFormsModule

  ],

})
export class CustomerModule { }
