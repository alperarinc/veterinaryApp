import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [

  {
    path: '',
    children:[
    {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
  {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
  {path: 'animal', loadChildren: './pages/animal/animal.module#AnimalModule'},
  {path: 'customer', loadChildren: './pages/customer/customer.module#CustomerModule'}]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
