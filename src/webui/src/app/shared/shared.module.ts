import { NgModule } from '@angular/core';
import { TranslateModule } from '@ngx-translate/core';
import {BsModalRef, ModalModule} from "ngx-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {ConfirmationComponent} from "./confirmation/confirmation.component";

@NgModule({
  exports:[
    TranslateModule,
    ModalModule,
    ReactiveFormsModule,
    ConfirmationComponent
  ],
  providers:[
    BsModalRef
  ],
  entryComponents:[
    ConfirmationComponent
  ],
  declarations: [
    ConfirmationComponent
  ],
  imports:[
    ModalModule.forRoot(),
    CommonModule,
    FormsModule,
  ],
})
export class SharedModule { }
