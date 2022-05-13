import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnimalComponent } from './animal.component';
import {AnimalRoutingModule} from "./animal.routing.module";

@NgModule({
  declarations: [AnimalComponent],
  imports: [
    CommonModule,
    AnimalRoutingModule
  ]
})
export class AnimalModule { }
