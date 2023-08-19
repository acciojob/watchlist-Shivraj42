package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    // 1

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);
    }


    //2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director), HttpStatus.OK);
    }

    //3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name") String mName, @RequestParam("director name") String dName){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(mName, dName), HttpStatus.OK);
    }

    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String mName){
        return new ResponseEntity<>(movieService.getMovieByName(mName), HttpStatus.OK);
    }

    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String dName){
        return new ResponseEntity<>(movieService.getDirectorByName(dName), HttpStatus.OK);
    }

    //6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String dName){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(dName), HttpStatus.OK);
    }


    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }

    //8
    @DeleteMapping ("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director’s name") String dName){
        return new ResponseEntity<>(movieService.deleteDirectorByName(dName), HttpStatus.OK);
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }









}
