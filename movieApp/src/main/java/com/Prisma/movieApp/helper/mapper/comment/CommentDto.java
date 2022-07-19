package com.Prisma.movieApp.helper.mapper.comment;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.helper.mapper.users.UserDto;

public class CommentDto {
    Long id;
    UserDto user;
    MovieDto movie;
    String comment;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
