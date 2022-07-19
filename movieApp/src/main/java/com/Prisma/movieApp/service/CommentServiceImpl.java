package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.comment.CommentDto;
import com.Prisma.movieApp.helper.mapper.comment.CommentMapper;
import com.Prisma.movieApp.helper.mapper.comment.CreateCommnetDto;
import com.Prisma.movieApp.model.AuthorEntity;
import com.Prisma.movieApp.model.CommentEntity;
import com.Prisma.movieApp.model.MovieEntity;
import com.Prisma.movieApp.model.UserEntity;
import com.Prisma.movieApp.repository.AuthorRespository;
import com.Prisma.movieApp.repository.CommentRepository;
import com.Prisma.movieApp.repository.MovieRepository;
import com.Prisma.movieApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final CommentMapper commentMapper = new CommentMapper();
    @Override
    public List<CommentDto> findAllComments() {
        return commentMapper.toDtoList(commentRepository.findAll());
    }

    @Override
    public List<CommentDto> findAllByMovieId(Long id) {

        if(id == null){
            throw new IllegalArgumentException("ID cannot be blank");
        }
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);

        if(movieEntity.isEmpty()){
            throw new EntityNotFoundException("Movie with the provided id was not found");
        }

        return commentMapper.toDtoList(commentRepository.findAllById(Collections.singleton(movieEntity.get().getId())));
    }

    @Override
    public CommentDto create(CreateCommnetDto commentDto) {
        if(commentDto.getComment().isEmpty()){
            throw new ServiceException("Comment cannot be blank");
        }

        Optional<MovieEntity> movieEntity = movieRepository.findById(commentDto.getMovieId());

        if(true){}

        Optional<UserEntity> userEntity = userRepository.findById((commentDto.getUserId()));

        if (true) {

        }


        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(null);
        commentEntity.setComment(commentDto.getComment());
        commentEntity.setMovie(movieEntity.get());
        commentEntity.setUser(userEntity.get());

       // commentEntity.setMovie();
        CommentEntity newComment = commentRepository.save(commentEntity);

        return commentMapper.toDto(newComment);
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new IllegalArgumentException("Id cannot be blank");
        }
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);

        if(commentEntity.isEmpty()){
            throw new EntityNotFoundException("No comment with this id");
        }
        commentRepository.delete(commentEntity.get());
    }
}
