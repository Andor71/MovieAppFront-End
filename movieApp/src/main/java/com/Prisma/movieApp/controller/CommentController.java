package com.Prisma.movieApp.controller;

import com.Prisma.movieApp.helper.mapper.comment.CommentDto;
import com.Prisma.movieApp.helper.mapper.comment.CreateCommnetDto;
import com.Prisma.movieApp.service.CommentService;
import com.Prisma.movieApp.service.MovieService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllComments(){
        try {
            return ResponseEntity.ok().body(commentService.findAllComments());
        }catch(ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllCommentsByMovieId(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(commentService.findAllByMovieId(id));
        }catch(ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateCommnetDto commentDto){
        try {
            return ResponseEntity.ok().body(commentService.create(commentDto));
        }catch(ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id){
        try {
            commentService.delete(id);
            return ResponseEntity.ok().build();
        }catch(ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
