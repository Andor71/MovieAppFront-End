import { AuthorDto } from "./author.model";

export class MovieDto{
    id: number;
    title: string;
    image: string;
    duration: string;
    genre: string;
    authorDto: AuthorDto;
    description: string;
}
