export class Category {
    id?: number;
    name?: string;
    orderNumber?: number;

    constructor(
        id: number,
        name: string,
        orderNumber: number
    ) {
        this.id = id;
        this.name = name;
        this.orderNumber = orderNumber;
    }
}
