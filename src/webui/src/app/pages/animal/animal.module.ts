import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnimalComponent } from './animal.component';
import {AnimalRoutingModule} from "./animal.routing.module";
import {AnimalService} from "../../services/shared/animal.service";

@NgModule({
  declarations: [AnimalComponent],
  providers:[AnimalService],
  imports: [
    CommonModule,
    AnimalRoutingModule
  ]
})
export class AnimalModule { }
