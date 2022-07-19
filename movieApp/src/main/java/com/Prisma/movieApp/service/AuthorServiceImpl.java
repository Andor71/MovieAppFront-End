package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.author.AuthorDto;
import com.Prisma.movieApp.helper.mapper.author.AuthorMapper;
import com.Prisma.movieApp.model.AuthorEntity;
import com.Prisma.movieApp.model.MovieEntity;
import com.Prisma.movieApp.repository.AuthorRespository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRespository authorRespository;

    private final AuthorMapper authorMapper = new AuthorMapper();
    @Override
    public List<AuthorDto> findAllAuthors() {
        return authorMapper.toDtoList(authorRespository.findAll());
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }

        Optional<AuthorEntity> authorEntity = authorRespository.findById(id);
        if(authorEntity.isEmpty()){
            throw new EntityNotFoundException("Author with the provided id was not found");
        }
        return authorMapper.toDto(authorEntity.get());
    }

    @Override
    public AuthorDto create(AuthorDto authorDto) {
        if(authorDto.getName().isEmpty()){
            throw new ServiceException("Author name cannot be blank");
        }

        AuthorEntity authorEntity = authorMapper.toEntity(authorDto);

        AuthorEntity newAutor = authorRespository.save(authorEntity);

        return authorMapper.toDto(newAutor);
    }

    @Override
    public Object update(AuthorDto authorDto) {

        if (authorDto.getId() == null){
            throw new IllegalArgumentException("Id cannot be blank");
        }
        if(authorDto.getName().isEmpty()){
            throw new ServiceException("Name cannot be blank");
        }
        Optional<AuthorEntity> authorOptional= authorRespository.findById(authorDto.getId());

        if(authorOptional.isEmpty()){
            throw new EntityNotFoundException("Author was not found with the provided id");
        }
        AuthorEntity author = authorOptional.get();

        AuthorEntity newAuthor = authorMapper.toEntity(authorDto);

        AuthorEntity authorEntity = authorRespository.save(newAuthor);

        return authorMapper.toDto(authorEntity);

    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }

        Optional<AuthorEntity> authorEntity = authorRespository.findById(id);
        if(authorEntity.isEmpty()){
            throw new EntityNotFoundException("Movie witth the provided id was not found");
        }
        authorRespository.delete(authorEntity.get());
    }

}
