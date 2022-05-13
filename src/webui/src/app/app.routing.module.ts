import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppLayoutComponent } from './_layout/app-layout/app-layout.component';



const routes: Routes = [
  {
    path: '', component: AppLayoutComponent,
    children: [
      { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
      { path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule' },
      { path: 'animal', loadChildren: './pages/animal/animal.module#AnimalModule' },
      { path: 'customer', loadChildren: './pages/customer/customer.module#CustomerModule' }
    ]
  }
];


@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
