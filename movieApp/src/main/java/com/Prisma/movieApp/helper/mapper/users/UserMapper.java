package com.Prisma.movieApp.helper.mapper.users;

import com.Prisma.movieApp.model.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public UserDto toDto(UserEntity userEntity){

        UserDto dto = new UserDto();

        dto.setId(userEntity.getId());
        dto.setUserName(userEntity.getUserName());

        return dto;

    }

    public List<UserDto> toDtoList(List<UserEntity> movieEntityList){
        return movieEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDto.getId());
        userEntity.setUserName(userDto.getUserName());

        return userEntity;
    }

    public List<UserEntity> toEntityList(List<UserDto> userDtos){
        return userDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
