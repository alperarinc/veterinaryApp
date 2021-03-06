import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { ApiService } from "../api.service";

@Injectable()
export class AnimalService {
  private ANIMAL_PATH = "/animal";
  private ANIMAL_GET_BY_ID_DETAILS =this.ANIMAL_PATH + "/detail/"

  constructor(private apiService: ApiService) {

  }

  getAll(page): Observable<any> {
    return this.apiService.get( this.ANIMAL_PATH+ '/pagination',page).pipe(map(
      res => {
        if (res) {
          return res
        } else {
          console.log(res);
          return {};
        }
      }

    ));
  }

  getById(id): Observable<any> {
    return this.apiService.get( this.ANIMAL_PATH,id).pipe(map(
      res => {
        if (res) {
          return res
        } else {
          console.log(res);
          return {};
        }
      }

    ));
  }

  CreateAnimal(animal): Observable<any> {
    return this.apiService.post( this.ANIMAL_PATH,animal).pipe(map(
      res => {
        if (res) {
          return res
        } else {
          console.log(res);
          return {};
        }
      }

    ));
  }

  delete(id): Observable<any> {
    return this.apiService.delete( this.ANIMAL_PATH,id).pipe(map(
      res => {
        if (res) {
          return res
        } else {
          console.log(res);
          return {};
        }
      }

    ));
  }

  getByIdWithDetails(id: number) {
    return this.apiService.get( this.ANIMAL_GET_BY_ID_DETAILS +id).pipe(map(
      res => {
        if (res) {
          return res
        } else {
          console.log(res);
          return {};
        }
      }

    ));
  }
}
