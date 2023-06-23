import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from 'src/app/model/Ticket';

@Injectable({
  providedIn: 'root'
})
export class BuyTicketService {

  constructor(private http: HttpClient) { }

  searchTickets(source:string, destination:string):Observable<Ticket[]>{
    console.log('in service')
    return this.http.get<Ticket[]>('http://localhost:8080/ticket/searchTicket?source='+source+'&destination='+destination);
  }
}
