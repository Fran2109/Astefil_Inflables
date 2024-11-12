import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './components/app/app.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { ArticleDetailComponent } from './components/article-detail/article-detail.component';
import { LoginComponent } from './components/login/login.component';
import { ContactComponent } from './components/contact/contact.component';
import { ConsultationsTableComponent } from './components/consultations-table/consultations-table.component';
import { EmployeesTableComponent } from './components/employees-table/employees-table.component';
import { CoverageZoneComponent } from './components/coverage-zone/coverage-zone.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'articles', component: ArticlesComponent },
  { path: 'articles/:id', component: ArticleDetailComponent },
  { path: 'login', component: LoginComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'consultations', component: ConsultationsTableComponent },
  { path: 'employees', component: EmployeesTableComponent },
  { path: 'coverage_zones', component: CoverageZoneComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
