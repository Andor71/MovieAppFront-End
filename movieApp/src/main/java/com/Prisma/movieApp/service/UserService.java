package com.Prisma.movieApp.service;


import com.Prisma.movieApp.helper.mapper.users.UserDto;

public interface UserService {

    /**
     * Gets user by id
     * @param id of user
     * @return UserDto
     */
    UserDto getUserById(Long id);
}
