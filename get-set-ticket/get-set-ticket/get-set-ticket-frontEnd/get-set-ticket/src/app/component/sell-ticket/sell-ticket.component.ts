import { Component, OnInit } from '@angular/core';
import { Ticket } from 'src/app/model/Ticket';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import { SellTicketService } from 'src/app/service/sell-ticket/sell-ticket.service';
import { AuthguardGuard } from 'src/app/guard/authguard.guard';


@Component({
  selector: 'app-sell-ticket',
  templateUrl: './sell-ticket.component.html',
  styleUrls: ['./sell-ticket.component.css']
})
export class SellTicketComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private sellService:SellTicketService, private auth:AuthguardGuard) { }

  newTicketForm: FormGroup | any;
  showNewTicketForm:boolean = false;
  newTicket:Ticket = new Ticket("", this.auth.loggedinUserId, "", "", new Date, new Date, "", 0, "" ,"", "", "", "Sell");
  tickets:Ticket[] = [];

  ngOnInit(): void {
    this.newTicketForm = this.formBuilder.group({
      source: [''],
      destination: [''],
      journeyStartDate: [''],
      journeyEndDate: [''],
      passengerName: [''],
      age: [''],
      gender: [''],
      pnrNo: [''],
      trainNo: [''],
      trainName: ['']
    });
    this.getTicketsByUserId();
  }

  createTicket(){
    this.newTicket.source = this.newTicketForm.get('source').value;
    this.newTicket.destination = this.newTicketForm.get('destination').value;
    this.newTicket.journeyStartDate = this.newTicketForm.get('journeyStartDate').value;
    this.newTicket.journeyEndDate = this.newTicketForm.get('journeyEndDate').value;
    this.newTicket.name = this.newTicketForm.get('passengerName').value;
    this.newTicket.age = this.newTicketForm.get('age').value;
    this.newTicket.gender = this.newTicketForm.get('gender').value;
    this.newTicket.pnrNo = this.newTicketForm.get('pnrNo').value;
    this.newTicket.trainNo = this.newTicketForm.get('trainNo').value;
    this.newTicket.trainName = this.newTicketForm.get('trainName').value;
    this.newTicket.action = 'Sell';
    this.sellService.sellTicket(this.newTicket).subscribe(response => {console.log('new ticket created'); this.showNewTicketForm=false; this.getTicketsByUserId()});
  }

  getTicketsByUserId(){
    this.sellService.getTicketsByUserid(this.auth.loggedinUserId).subscribe(response => {this.tickets = response; console.log(this.tickets)});
  }

  deleteTicket(ticketId:string){
    this.sellService.deleteTicket(ticketId).subscribe(() => {this.getTicketsByUserId()});
  }

}
