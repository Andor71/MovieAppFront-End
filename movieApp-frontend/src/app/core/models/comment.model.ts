import { MovieDto } from "./movie.model";
import { UserDto } from "./user.model";

export class CommentDto {
  id: number;
  comment: string;
  user: UserDto;
  movie: MovieDto;
}
