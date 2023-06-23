import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from 'src/app/model/Ticket';


@Injectable({
  providedIn: 'root'
})
export class SellTicketService {

  constructor(private http: HttpClient) { }

  sellTicket(ticket:Ticket){
    console.log('in service');
    return this.http.post('http://localhost:8080/ticket/create', ticket);
  }

  getTicketsByUserid(userId:string):Observable<Ticket[]> {
    return this.http.get<Ticket[]>('http://localhost:8080/ticket/getTicketByUserId/'+userId);
  }

  deleteTicket(ticketId:string):Observable<string>{
    return this.http.delete<string>('http://localhost:8080/ticket/delete/'+ticketId);
  }
}
