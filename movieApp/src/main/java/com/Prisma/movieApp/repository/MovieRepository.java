package com.Prisma.movieApp.repository;

import com.Prisma.movieApp.model.AuthorEntity;
import com.Prisma.movieApp.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long> {

    List<MovieEntity> findAllByAuthor(AuthorEntity authorEntity);

}
