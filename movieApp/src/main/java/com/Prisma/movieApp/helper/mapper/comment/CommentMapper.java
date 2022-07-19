package com.Prisma.movieApp.helper.mapper.comment;

import com.Prisma.movieApp.helper.mapper.author.AuthorMapper;
import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.helper.mapper.movie.MovieMapper;
import com.Prisma.movieApp.helper.mapper.users.UserMapper;
import com.Prisma.movieApp.model.CommentEntity;
import com.Prisma.movieApp.model.MovieEntity;
import com.Prisma.movieApp.repository.CommentRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    private final UserMapper userMapper= new UserMapper();
    private final MovieMapper movieMapper = new MovieMapper();
    public CommentDto toDto(CommentEntity commentEntity){

        CommentDto dto = new CommentDto();

        dto.setId(commentEntity.getId());
        dto.setUser(userMapper.toDto(commentEntity.getUser()));
        dto.setComment(commentEntity.getComment());
        dto.setMovie(movieMapper.toDto(commentEntity.getMovie()));
        return dto;

    }

    public List<CommentDto> toDtoList(List<CommentEntity> commentEntityList){
        return commentEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CommentEntity toEntity(CommentDto commentDto){
        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setId(commentDto.getId());
        commentEntity.setUser(userMapper.toEntity(commentDto.getUser()));
        commentEntity.setComment(commentDto.getComment());
        commentEntity.setMovie(movieMapper.toEntity(commentDto.getMovie()));

        return commentEntity;
    }

    public List<CommentEntity> toEntityList(List<CommentDto> commentDto){
        return commentDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
