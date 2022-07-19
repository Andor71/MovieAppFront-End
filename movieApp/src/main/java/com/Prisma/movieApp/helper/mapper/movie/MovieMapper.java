package com.Prisma.movieApp.helper.mapper.movie;

import com.Prisma.movieApp.helper.mapper.author.AuthorMapper;
import com.Prisma.movieApp.model.MovieEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class MovieMapper {

    private final AuthorMapper authorMapper = new AuthorMapper();
    public  MovieDto toDto(MovieEntity movieEntity){

        MovieDto dto = new MovieDto();

        dto.setId(movieEntity.getId());
        dto.setTitle(movieEntity.getTitle());
        dto.setDuration(movieEntity.getDuration());
        dto.setGenre(movieEntity.getGenre());
        dto.setAuthorDto(authorMapper.toDto(movieEntity.getAuthor()));
        dto.setImage(movieEntity.getImage());
        dto.setDescription(movieEntity.getDescription());
        return dto;

    }

    public List<MovieDto> toDtoList(List<MovieEntity> movieEntityList){
        return movieEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public MovieEntity toEntity(MovieDto movieDto){
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setId(movieDto.getId());
        movieEntity.setTitle(movieDto.getTitle());
        movieEntity.setGenre(movieDto.getGenre());
        movieEntity.setDuration(movieDto.getDuration());
        movieEntity.setImage(movieDto.getImage());
        movieEntity.setAuthor(authorMapper.toEntity(movieDto.getAuthorDto()));
        movieEntity.setDescription(movieDto.getDescription());
        return movieEntity;
    }

    public List<MovieEntity> toEntityList(List<MovieDto> movieDtos){
        return movieDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
