import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AnimalService} from "../../../services/shared/animal.service";
import {CustomerService} from "../../../services/shared/customer.service";
import {AnimalHistoryService} from "../../../services/shared/animalHistory.service";
import {UserService} from "../../../services/shared/user.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-animal-detail',
  templateUrl: './animal-detail.component.html',
  styleUrls: ['./animal-detail.component.css']
})
export class AnimalDetailComponent implements OnInit {

  id: number;
  private sub: any;

  animalDetail = {};

  columns = [];
  datatable_rows: [];
  assigneeOptions = [];
  customerOptions = [];
  animalDetailForm: FormGroup;


  constructor(private route: ActivatedRoute,
              private userService: UserService,
              private animalHistoryService: AnimalHistoryService,
              private customerService: CustomerService,
              private formBuilder: FormBuilder,
              private animalService: AnimalService) {
  }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];
      this.loadAnimalDetails();
    });

    this.columns = [
      {prop: 'id', name: 'No'},
      {prop: 'description', name: 'Description'},
      {prop: 'age', name: 'Animal Age'},
      {prop: 'type', name: 'Animal Type'},
      {prop: 'gender', name: 'Animal Gender'},
      {prop: 'assignee.surname', name: 'Assignee'},
      {prop: 'assignee.name', name: 'Assignee'},
      {prop: 'animal.customer.customerName', name: 'Customer Name'},
    ];
    this.loadCustomers();
    this.loadAssignees();

  }


  private loadAssignees() {
    this.userService.getAll().subscribe(response => {
      this.assigneeOptions = response;
    })
  }

  private loadCustomers() {
    this.customerService.getAllId().subscribe(response => {
      this.customerOptions = response;
    })
  }

  private loadAnimalDetails() {
    this.animalService.getByIdWithDetails(this.id).subscribe(response => {
      this.animalDetailForm = this.createAnimalDetailFormGroup(response);
      this.datatable_rows= response['animalHistories'];
    })
  }

  createAnimalDetailFormGroup(response) {
    return this.formBuilder.group({
      id: response['id'],
      description: response['description'],
      details: response['details'],
      age: response['age'],
      issueStatus: response['issueStatus'],
      assignee_id: response['assignee']? response['assignee']['id'] : '',
      project_id: response['project'] ? response['project']['id'] : '',
      project_manager: response['project'] && response['project']['manager'] ? response['project']['manager']['nameSurname']: '',
    });
  }
}

