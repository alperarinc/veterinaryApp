import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {CustomerService} from "../../services/shared/customer.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";
import {template} from "@angular/core/src/render3";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  modalRef: BsModalRef;
  customerForm: FormGroup;

  @ViewChild('tplCustomerDeleteCell') tplCustomerDeleteCell: TemplateRef<any>

  page = new Page();
  cols = [];
  rows = [];

  constructor(private customerService: CustomerService, private modalService: BsModalService, private formBuilder: FormBuilder) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  ngOnInit(): void {
    this.setPage({offset: 0});
    this.customerForm = this.formBuilder.group({
      'customerCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'customerName': [null, [Validators.required, Validators.minLength(4)]],
    });
  }

  get f() {
    return this.customerForm.controls
  }


  setPage(pageInfo) {
    this.cols = [
      {prop: 'id', name: 'No'},
      {prop: 'customerName', name: 'Customer Name', sortable: false},
      {prop: 'customerCode', name: 'Customer Code', sortable: false},
      {prop: 'id', name: 'Actions', cellTemplate: this.tplCustomerDeleteCell, flexGrow: 1, sortable: false}
    ];

    this.page.page = pageInfo.offset;
    this.customerService.getAll(this.page).subscribe(pagedData => {
      this.page.size = pagedData.size;
      this.page.page = pagedData.page;
      this.page.totalElements = pagedData.totalElements;
      this.rows = pagedData.content;
    });
  }

  saveProject() {
    if (!this.customerForm.valid)
      return;

    this.customerService.CreateProject(this.customerForm.value).subscribe(
      response => {
        console.log(response)
      }
    )
    this.setPage({offset: 0});
    this.closeAndResetModal();
  }

  closeAndResetModal() {
    this.customerForm.reset();
    this.modalRef.hide();
  }

  showDeleteConfirmation() {
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Test Modal',
      'Test Body'
    );
    (<ConfirmationComponent>modal.content).onClose.subscribe(result => {
      if (result === true) {
        console.log("Yes")
      } else if (result === false) {
        console.log("No")
      }
    })
  }

  showCustomerDeleteConfirmation(value): void {
    const modal = this.modalService.show(ConfirmationComponent);
    (<ConfirmationComponent>modal.content).showConfirmation(
      'Delete Confirmation',
      'Are you sure for delete Customer'
    );
    (<ConfirmationComponent>modal.content).onClose.subscribe(result => {
      if (result === true) {
        this.customerService.delete(value).subscribe(response => {
          if (response === true) {
            this.setPage({offset: 0})
          }
        });
      } else if (result === false) {
      }
    })
  }
}
