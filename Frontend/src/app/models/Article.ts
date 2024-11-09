import { Image } from "./Image";

export class Article {
    id?: number;
    name?: string;
    description?: string;
    height?: number;
    width?: number;
    length?: number;
    images?: Image[];
    categoryId?: number;

    constructor(
        id: number,
        name: string,
        description: string,
        height: number,
        width: number,
        length: number,
        images: Image[],
        categoryId: number
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.length = length;
        this.images = images;
        this.categoryId = categoryId;
    }
}
