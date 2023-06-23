import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import { Ticket } from 'src/app/model/Ticket';
import { BuyTicketService } from 'src/app/service/buy-ticket/buy-ticket.service';

@Component({
  selector: 'app-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.css']
})
export class BuyTicketComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private buyService:BuyTicketService) { }

  searchTicketForm: FormGroup | any;
  tickets:Ticket[] = [];

  ngOnInit(): void {
    this.searchTicketForm = this.formBuilder.group({
      source: [''],
      destination: [''],
      journeyStartDate: [''],
    });
  }

  searchTicket(){
    let source:string = this.searchTicketForm.get('source').value;
    let destination = this.searchTicketForm.get('destination').value;
    this.buyService.searchTickets(source, destination).subscribe(response => {
      this.tickets = response;
    })
  }


}
