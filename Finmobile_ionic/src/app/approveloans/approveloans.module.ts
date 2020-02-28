import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ApproveloansPageRoutingModule } from './approveloans-routing.module';

import { ApproveloansPage } from './approveloans.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ApproveloansPageRoutingModule
  ],
  declarations: [ApproveloansPage]
})
export class ApproveloansPageModule {}
