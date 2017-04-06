import {Review} from "./review";

export class Coffee {
  id: number;
  name: string;
  volume: number;
  vendor: string;
  country: string;
  notes: string;
  price: number;
  introduced: any;
  reviews: Review[];
}

