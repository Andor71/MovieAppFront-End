package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.author.AuthorDto;

import java.util.List;

public interface AuthorService {

    /**
     * Return all Authors
     * @return List<AuthorDto>
     */
    List<AuthorDto> findAllAuthors();

    /**
     * Returns author by id
     * @return  AuthorDto
     */
    AuthorDto getAuthorById(Long id);

    /**
     * Creates a new Author
     * @param authorDto AuthorDto object
     * @return AuthorDto object
     */
    AuthorDto create(AuthorDto authorDto);

    /**
     * Updates author
     * @param authorDto AuthorDto object
     * @return AuthorDto
     */
    Object update(AuthorDto authorDto);

    /**
     * Deletes Author
     * @param id
     */
    void delete(Long id);
}
