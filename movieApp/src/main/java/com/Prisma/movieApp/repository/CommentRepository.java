package com.Prisma.movieApp.repository;

import com.Prisma.movieApp.model.CommentEntity;
import com.Prisma.movieApp.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
