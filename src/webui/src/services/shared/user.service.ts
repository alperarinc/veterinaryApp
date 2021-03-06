import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { ApiService } from "../api.service";

@Injectable({
  providedIn:'root'
})
export class UserService {
    private USER_PATH = "/user";

    constructor(private apiService: ApiService) {

    }

    getAll(): Observable<any> {
        return this.apiService.get( this.USER_PATH).pipe(map(
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
        return this.apiService.get( this.USER_PATH,id).pipe(map(
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

    CreateUser(user): Observable<any> {
        return this.apiService.post( this.USER_PATH,user).pipe(map(
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
