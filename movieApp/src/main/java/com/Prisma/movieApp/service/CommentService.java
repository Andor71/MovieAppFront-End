package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.comment.CommentDto;
import com.Prisma.movieApp.helper.mapper.comment.CreateCommnetDto;

import java.util.List;

public interface CommentService {

    /**
     * Get All Comments
     * @return list of CommentDto
     */
    List<CommentDto> findAllComments();

    /**
     * Finds all Comment by movie ID
     * @param id Movie id
     * @return CommentDto
     */
    List<CommentDto> findAllByMovieId(Long id);

    /**
     * Create Comment
     * @param commentDto
     * @return
     */
    CommentDto create(CreateCommnetDto commentDto);

    /**
     * Delete comment
     * @param id comment id
     */
    void delete(Long id);
}
