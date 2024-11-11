import { User } from "./User";

export class UserQuery {
    id?: number;
    firstName?: string;
    lastName?: string;
    zoneId?: number;
    date?: string;
    createdDateTime?: string;
    answeredDateTime?: string;
    generalQuery?: string;
    phone?: string;
    isAnswered?: boolean;
    answeredByUser?: User;

    constructor(id: number, firstName: string, lastName: string, zoneId: number, date: string, createdDateTime: string, answeredDateTime: string, generalQuery: string, phone: string, isAnswered: boolean, answeredByUser: User) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zoneId = zoneId;
        this.date = date;
        this.createdDateTime = createdDateTime;
        this.answeredDateTime = answeredDateTime;
        this.generalQuery = generalQuery;
        this.phone = phone;
        this.isAnswered = isAnswered;
        this.answeredByUser = answeredByUser;
    }
}