export class Boleto {
    dueDate: string;
    amount: number;
    beneficiary: string

    constructor(dueDate:string, amount:number, beneficiary:string) {
        this.dueDate = dueDate;
        this.amount = amount;
        this.beneficiary = beneficiary;
    }
}