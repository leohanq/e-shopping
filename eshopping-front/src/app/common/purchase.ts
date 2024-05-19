import { Customer } from "./customer";
import { Order } from "./order";
import { OrderItem } from "./order-item";

export class Purchase {
    customer: Customer;
    billingAddress: String;
    order: Order;
    orderItems: OrderItem[]; 
}
