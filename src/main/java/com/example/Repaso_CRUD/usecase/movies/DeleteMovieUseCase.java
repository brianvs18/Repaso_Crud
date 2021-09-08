package com.example.Repaso_CRUD.usecase.movies;

import com.example.Repaso_CRUD.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DeleteMovieUseCase {

    private final MovieRepository movieRepository;

    @Autowired
    public DeleteMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Mono<Void> deleteMovieById(String id){
        return movieRepository.deleteById(id);
    }
}
