import {Coffee} from "./coffee";
export class Review {
  id: number;
  username: string;
  comment: string;
  rate: number;
  aroma: number;
  taste: number;
  acidity: number;
  aftertaste: number;
  saturation: number;
  timestamp: any;
  coffee: Coffee;
}
