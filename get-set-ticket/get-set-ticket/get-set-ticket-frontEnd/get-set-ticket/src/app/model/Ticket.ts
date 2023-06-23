export class Ticket {
    constructor(
        public ticketId:string,
        public userId:string,
        public source:string,
        public destination:string,
        public journeyStartDate:Date,
        public journeyEndDate:Date,
        public name:string,
        public age:number,
        public gender:string,
        public pnrNo:string,
        public trainNo:string,
        public trainName:string,
        public action:string
    ) {}
}