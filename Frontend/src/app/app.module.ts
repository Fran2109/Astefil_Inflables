import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatFormFieldModule, MatError } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from "@angular/material/grid-list";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatSelectModule } from "@angular/material/select";
import { MatOptionModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule } from "@angular/material/core";
import { MatTableModule } from "@angular/material/table";
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';

import { AppComponent } from './components/app/app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { ArticlesComponent } from './components/articles/articles.component';
import { ArticleDetailComponent } from './components/article-detail/article-detail.component';
import { CreateCategoryComponent } from './components/create-category/create-category.component';
import { ConfirmDeleteCategoryComponent } from './components/confirm-delete-category/confirm-delete-category.component';
import { EditCategoryComponent } from './components/edit-category/edit-category.component';
import { CreateArticleComponent } from './components/create-article/create-article.component';
import { ConfirmDeleteArticleComponent } from './components/confirm-delete-article/confirm-delete-article.component';
import { EditArticleComponent } from './components/edit-article/edit-article.component';
import { LoginComponent } from './components/login/login.component';
import { ContactComponent } from './components/contact/contact.component';
import { ConsultationsTableComponent } from './components/consultations-table/consultations-table.component';
import { ReplyConsultationModalComponent } from './components/reply-consultation-modal/reply-consultation-modal.component';
import { EmployeesTableComponent } from './components/employees-table/employees-table.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EditEmployeeComponent } from './components/edit-employee/edit-employee.component';
import { ConfirmDeleteEmployeeComponent } from './components/confirm-delete-employee/confirm-delete-employee.component';
import { CoverageZoneComponent } from './components/coverage-zone/coverage-zone.component';
import { CreateZoneComponent } from './components/create-zone/create-zone.component';
import { ConfirmDeleteZoneComponent } from './components/confirm-delete-zone/confirm-delete-zone.component';
import { EditZoneComponent } from './components/edit-zone/edit-zone.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LandingPageComponent,
    ArticlesComponent,
    ArticleDetailComponent,
    CreateCategoryComponent,
    ConfirmDeleteCategoryComponent,
    EditCategoryComponent,
    CreateArticleComponent,
    ConfirmDeleteArticleComponent,
    EditArticleComponent,
    LoginComponent,
    ContactComponent,
    ConsultationsTableComponent,
    ReplyConsultationModalComponent,
    EmployeesTableComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    ConfirmDeleteEmployeeComponent,
    CoverageZoneComponent,
    CreateZoneComponent,
    ConfirmDeleteZoneComponent,
    EditZoneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTabsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    CarouselModule,
    MatDialogModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatError,
    CommonModule,
    FormsModule,
    MatGridListModule,
    MatSidenavModule,
    MatSelectModule,
    MatOptionModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }