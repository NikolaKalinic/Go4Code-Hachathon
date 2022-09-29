import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Router, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { MainComponent } from './main/main.component';
import { AppService } from './app.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CommentsListComponent } from './comments-list/comments-list.component';
import { AddPostComponent } from './add-post/add-post.component';

@NgModule({
  declarations: [AppComponent, LoginComponent, SignupComponent, MainComponent, PageNotFoundComponent, CommentsListComponent, AddPostComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [AppService],
  bootstrap: [AppComponent],
})
export class AppModule {}
