import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {CustomerService} from "../../services/shared/customer.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ConfirmationComponent} from "../../shared/confirmation/confirmation.component";
import {UserService} from "../../services/shared/user.service";

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
  managerOptions = [];

  constructor(private customerService: CustomerService,
              private modalService: BsModalService,
              private formBuilder: FormBuilder,
              private userService: UserService) {
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  ngOnInit(): void {
    this.setPage({offset: 0});
    this.customerForm = this.formBuilder.group({
      'customerCode': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(10)]],
      'customerName': [null, [Validators.required, Validators.minLength(4)]],
      'customerSurname': [null, [Validators.required, Validators.minLength(4)]],
      'telNumber': [null, [Validators.required, Validators.minLength(11), Validators.maxLength(11)]],
      'address': [null, [Validators.required, Validators.minLength(10), Validators.maxLength(50)]],
      'email': [null, [Validators.required, Validators.minLength(10), Validators.maxLength(20)]],
      'managerId': [null, [Validators.required]]
      ,
    });
    this.userService.getAll().subscribe(res => {
      this.managerOptions = res;
      console.log(res);
    })
  }

  get f() {
    return this.customerForm.controls
  }


  setPage(pageInfo) {
    this.cols = [
      {prop: 'id', name: 'No'},
      {prop: 'customerName', name: 'Customer Name', sortable: false},
      {prop: 'customerSurname', name: 'Customer Surname', sortable: false},
      {prop: 'customerCode', name: 'Customer Code', sortable: false},
      {prop: 'telNumber', name: 'Customer Phone', sortable: false},
      {prop: 'address', name: 'Customer Address', sortable: false},
      {prop: 'email', name: 'Customer E-mail', sortable: false},
      {prop: 'manager.username', name: 'Manager', sortable: false},
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

  saveCustomer() {
    if (!this.customerForm.valid)
      return;

    this.customerService.CreateCustomer(this.customerForm.value).subscribe(
      response => {
        this.setPage({offset: 0});
        this.closeAndResetModal();      }
    )

  }

  closeAndResetModal() {
    this.customerForm.reset();
    this.modalRef.hide();
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
