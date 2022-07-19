package com.Prisma.movieApp.helper.mapper.author;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.model.AuthorEntity;
import com.Prisma.movieApp.model.MovieEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {
    public AuthorDto toDto(AuthorEntity entity){

        AuthorDto dto = new AuthorDto();

        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setBirthday(entity.getBirthday());

        return dto;

    }

    public List<AuthorDto> toDtoList(List<AuthorEntity> movieAuthorList){
        return movieAuthorList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public AuthorEntity toEntity(AuthorDto authorDto){
        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setImage(authorDto.getImage());
        authorEntity.setId(authorDto.getId());
        authorEntity.setName(authorDto.getName());
        authorEntity.setBirthday(authorDto.getBirthday());

        return authorEntity;
    }

    public List<AuthorEntity> toEntityList(List<AuthorDto> authorDtos){
        return authorDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }


}
