export class Article {
    id?: number;
    name?: string;
    description?: string;
    images?: string[];
    categoryId?: number;

    constructor(
        id: number,
        name: string,
        description: string,
        images: string[],
        categoryId: number
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.categoryId = categoryId;
    }
}
