export class customer {
  constructor(
    public emailId: string = '',
    public password: string = '',
    public firstName: string = '',
    public lastName: string = '',
    public role: string = '',
    public inCartNo: number = 0,
    public inCart: string = ''
  ) {}

  toString() {
    return (
      'Email Id is:- ' +
      this.emailId +
      'Paswword is:- ' +
      this.password +
      'First Name is:- ' +
      this.firstName +
      'Last Name is:- ' +
      this.lastName +
      'Role is:- ' +
      this.role +
      'in cart no is:- ' +
      this.inCartNo +
      'in cart is:- ' +
      this.inCart
    );
  }
}
