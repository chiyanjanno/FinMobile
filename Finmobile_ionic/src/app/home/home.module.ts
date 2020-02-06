import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginPage } from '../auth/login/login.page';
import { RegisterPage } from '../auth/register/register.page';
import { IonicModule } from '@ionic/angular';

import { HomePageRoutingModule } from './home-routing.module';

import { HomePage } from './home.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule
  ],
  declarations: [HomePage, LoginPage, RegisterPage],
  entryComponents: [LoginPage, RegisterPage]
})
export class HomePageModule {}
