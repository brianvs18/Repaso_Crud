package com.example.Repaso_CRUD.usecase.movies;

import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import com.example.Repaso_CRUD.repository.MovieRepository;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ListMoviesUseCase {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public ListMoviesUseCase(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    public Flux<MoviesDocumentDTO> findAllMovies(){
        return movieRepository.findAll().map(movieMapper.mapMovieToDTO());
    }

    public Mono<MoviesDocumentDTO> findMovieById(String movieId){
        return movieRepository.findById(movieId).map(movieMapper.mapMovieToDTO());
    }
}
