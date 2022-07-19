package com.Prisma.movieApp.service;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.helper.mapper.movie.MovieMapper;
import com.Prisma.movieApp.model.AuthorEntity;
import com.Prisma.movieApp.model.MovieEntity;
import com.Prisma.movieApp.repository.AuthorRespository;
import com.Prisma.movieApp.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final AuthorRespository authorRespository;
    private final MovieMapper movieMapper = new MovieMapper();

    @Override
    public List<MovieDto> findAllMovies() {
        return  movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDto create(MovieDto movieDto) {
        if(movieDto.getTitle().isEmpty()){
            throw new ServiceException("Movie Title cannot be blank");
        }
        Optional<AuthorEntity> authorOptional = authorRespository.findById(movieDto.getAuthorDto().getId());

        if(authorOptional.isEmpty()){
            throw new EntityNotFoundException("Author was not found with the provided id");
        }

        MovieEntity movieEntity = movieMapper.toEntity(movieDto);

        MovieEntity newMovie = movieRepository.save(movieEntity);

        return movieMapper.toDto(newMovie);
    }

    @Override
    public MovieDto update(MovieDto movieDto) {
        if (movieDto.getId() == null){
            throw new IllegalArgumentException("Id cannot be blank");
        }
        if(movieDto.getTitle().isEmpty()){
            throw new ServiceException("Movie Title cannot be blank");
        }

        Optional<MovieEntity> movieOptional = movieRepository.findById((movieDto.getId()));

        if(movieOptional.isEmpty()){
            throw  new EntityNotFoundException("The Object wit the provided ID was not found");
        }

        MovieEntity movieEntity = movieMapper.toEntity(movieDto);

        MovieEntity newMovie = movieRepository.save(movieEntity);

        return movieMapper.toDto(newMovie);
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }

        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if(movieEntity.isEmpty()){
            throw new EntityNotFoundException("Movie witth the provided id was not found");
        }
        movieRepository.delete(movieEntity.get());
    }

    @Override
    public MovieDto getMovieByid(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }

        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if(movieEntity.isEmpty()){
            throw new EntityNotFoundException("Movie witth the provided id was not found");
        }
        return  movieMapper.toDto(movieEntity.get());
    }

    @Override
    public List<MovieDto> getMovieByAuthorId(Long id) {
        if(id == null){
            throw new ServiceException("Id cannot be null");
        }
        Optional<AuthorEntity> authorEntity = authorRespository.findById(id);

        if(authorEntity.isEmpty()){
            throw new IllegalArgumentException("No Author with this id");
        }

        List<MovieEntity> movieEntities = movieRepository.findAllByAuthor(authorEntity.get());

        return movieMapper.toDtoList(movieEntities);
    }

}
