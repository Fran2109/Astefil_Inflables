import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './components/app/app.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { ArticlesComponent } from './components/articles/articles.component';

const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'inflables', component: ArticlesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
