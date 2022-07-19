package com.Prisma.movieApp.repository;

import com.Prisma.movieApp.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRespository extends JpaRepository<AuthorEntity,Long> {

}
