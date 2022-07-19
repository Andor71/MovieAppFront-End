package com.Prisma.movieApp.controller;

import com.Prisma.movieApp.helper.mapper.author.AuthorDto;
import com.Prisma.movieApp.helper.mapper.movie.MovieDto;
import com.Prisma.movieApp.service.AuthorService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAuthors(){
        try {
            return ResponseEntity.ok().body(authorService.findAllAuthors());
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(authorService.getAuthorById(id));
        }
        catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AuthorDto authorDto){
        try{
            return ResponseEntity.ok().body(authorService.create(authorDto));
        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AuthorDto authorDto){
        try{
            return ResponseEntity.ok().body(authorService.update(authorDto));
        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id){
        try {
            authorService.delete(id);
            return ResponseEntity.ok().build();
        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
