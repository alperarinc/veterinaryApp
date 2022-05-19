import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { ApiService } from "../api.service";

@Injectable()
export class AnimalHistoryService {
  private ANIMAL_HISTORY_PATH = "/animal/history";

  constructor(private apiService: ApiService) {

  }

  getAll(): Observable<any> {
    return this.apiService.get( this.ANIMAL_HISTORY_PATH).pipe(map(
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
    return this.apiService.get( this.ANIMAL_HISTORY_PATH,id).pipe(map(
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

  CreateIssue(animal): Observable<any> {
    return this.apiService.post( this.ANIMAL_HISTORY_PATH,animal).pipe(map(
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
    return this.apiService.delete( this.ANIMAL_HISTORY_PATH,id).pipe(map(
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
  getAllAnimalHistory(){
    //TODO
  }

}
