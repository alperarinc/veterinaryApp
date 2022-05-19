import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnimalComponent } from './animal.component';
import {AnimalDetailComponent} from "./animal-detail/animal-detail.component";

const routes: Routes = [
  {
    path: '',component: AnimalComponent
  },
  {
    path: '/animal/animal-detail/:id',component: AnimalDetailComponent
  }
];


@NgModule({

  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class AnimalRoutingModule { }
