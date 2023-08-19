package com.driver;

import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movies= new HashMap<>();
    HashMap<String, Director> directors= new HashMap<>();
    HashMap<String, List<String>> moviesOfDirector= new HashMap<>();

    public String addMovie(Movie movie) {
        movies.put(movie.getName(), movie);
        return "success";
    }

    public String addDirector(Director director) {
        directors.put(director.getName(), director);
        moviesOfDirector.put(director.getName(), new ArrayList<>());
        return "success";
    }

    public String addMovieDirectorPair(String mName, String dName) {
        moviesOfDirector.get(dName).add(mName);
        return "success";
    }

    public Movie getMovieByName(String mName) {
        return movies.get(mName);
    }

    public Director getDirectorByName(String dName) {
        return directors.get(dName);
    }

    public List<String> getMoviesByDirectorName(String dName) {
        return moviesOfDirector.get(dName);
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movies.keySet());
    }

    public String deleteDirectorByName(String dName) {

        for(String movie: moviesOfDirector.get(dName)){
            movies.remove(movie);
        }
        moviesOfDirector.remove(dName);
        directors.remove(dName);
        return "success";
    }

    public String deleteAllDirectors() {
        for(String director: directors.keySet()){
            for(String movie: moviesOfDirector.get(director)){
                movies.remove(movie);
            }
            moviesOfDirector.remove(director);
        }
        directors.clear();
        return "success";
    }
}
