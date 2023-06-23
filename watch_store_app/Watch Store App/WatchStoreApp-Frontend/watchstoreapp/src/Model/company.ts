export class company {
  constructor(
    public id: number = 0,
    public companyId: number = 0,
    public companyName: string = '',
    public companyImage: string = ''
  ) {}

  toString() {
    return (
      'Id is:- ' +
      this.id +
      'Company Id is:- ' +
      this.companyId +
      'Company Name is:- ' +
      this.companyName +
      'Company Image is:- ' +
      this.companyImage
    );
  }
}
