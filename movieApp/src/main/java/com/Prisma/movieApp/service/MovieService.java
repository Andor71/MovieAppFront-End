package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.model.MovieEntity;

import java.util.List;

public interface MovieService {

    /**
     * Return all movies from db
     * @return List<MoviesEntity>
     */
    List<MovieDto> findAllMovies();

    /**
     * Create new Movie object
     * @return MovieDto
     */

    MovieDto create(MovieDto movieDto);

    /**
     * Update a Movie object
     * @return MovieDto
     */

    MovieDto update(MovieDto movieDto);

    /**
     * Deletes the Movie object from DB
     * @param id of the selected Movie
     */
    void delete(Long id);

    /**
     * Return one Movie
     * @param id of the the Movie
     * @return movieDto
     */
    MovieDto getMovieByid(Long id);

    /**
     * Return MovieDto
     * @param id ot the Autor
     * @return movieDto
     */
    Object getMovieByAuthorId(Long id);
}
