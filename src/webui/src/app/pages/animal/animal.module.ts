import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnimalComponent } from './animal.component';
import {AnimalRoutingModule} from "./animal.routing.module";
import {AnimalService} from "../../services/shared/animal.service";
import {SharedModule} from "../../shared/shared.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {AnimalDetailComponent} from "./animal-detail/animal-detail.component";

@NgModule({
  declarations: [AnimalComponent,AnimalDetailComponent],
  providers:[AnimalService],
    imports: [
        CommonModule,
        AnimalRoutingModule,
        SharedModule,
        NgxDatatableModule
    ]
})
export class AnimalModule { }
