export class product {
  constructor(
    public id: number = 1,
    public companyId: number = 10,
    public productImage: string = '',
    public productCompany: string = '',
    public productName: string = '',
    public productDescription: string = '',
    public isLatestProduct: number = 0,
    public isSmartWatchProduct: number = 0,
    public productPrice: number = 0
  ) {}

  toString() {
    return (
      'Product [id=' +
      this.id +
      ', companyId=' +
      this.companyId +
      ', productImage=' +
      this.productImage +
      ', productName=' +
      this.productName +
      ', productDescription=' +
      this.productDescription +
      ', isLatestProduct=' +
      this.isLatestProduct +
      ', isSmartWatchProduct=' +
      this.isSmartWatchProduct +
      'Company Name:- ' +
      this.productCompany +
      'Product Price:- ' +
      this.productPrice +
      ']'
    );
  }
}
