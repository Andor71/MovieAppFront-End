package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.helper.mapper.users.UserDto;
import com.Prisma.movieApp.helper.mapper.users.UserMapper;
import com.Prisma.movieApp.model.MovieEntity;
import com.Prisma.movieApp.model.UserEntity;
import com.Prisma.movieApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper = new UserMapper();
    private final UserRepository userRepository;
    @Override
    public UserDto getUserById(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }

        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isEmpty()){
            throw new EntityNotFoundException("Movie with the provided id was not found");
        }
        return userMapper.toDto(userEntity.get());
    }
}
