package com.Prisma.movieApp.controller;

import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.service.MovieService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllMovies(){
        try {
            return ResponseEntity.ok().body(movieService.findAllMovies());
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(movieService.getMovieByid(id));
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<?> getMovieByAutorId(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(movieService.getMovieByAuthorId(id));
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMovie(@RequestBody MovieDto movieDto){
        try{
            return ResponseEntity.ok().body(movieService.create(movieDto));
        }        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody MovieDto movieDto){
        try{
            return ResponseEntity.ok().body(movieService.update(movieDto));
        }        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        try{
            movieService.delete(id);
            return ResponseEntity.ok().build();
        }        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
