import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { ApiService } from "../api.service";

@Injectable()
export class CustomerService {
    private CUSTOMER_PATH = "/customer";

    constructor(private apiService: ApiService) {

    }

    getAll(page): Observable<any> {
        return this.apiService.get( this.CUSTOMER_PATH + '/pagination',page).pipe(map(
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
        return this.apiService.get( this.CUSTOMER_PATH,id).pipe(map(
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

    CreateCustomer(project): Observable<any> {
        return this.apiService.post( this.CUSTOMER_PATH,project).pipe(map(
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
        return this.apiService.delete( this.CUSTOMER_PATH,id).pipe(map(
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
