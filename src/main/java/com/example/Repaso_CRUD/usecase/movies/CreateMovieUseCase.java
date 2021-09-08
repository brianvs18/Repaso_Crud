package com.example.Repaso_CRUD.usecase.movies;

import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import com.example.Repaso_CRUD.enums.CinemaErrorEnum;
import com.example.Repaso_CRUD.exception.CinemaException;
import com.example.Repaso_CRUD.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;
import com.example.Repaso_CRUD.repository.MovieRepository;

import java.util.Objects;

@Service
@Validated
public class CreateMovieUseCase {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public CreateMovieUseCase(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public Mono<MoviesDocumentDTO> createMovie(MoviesDocumentDTO moviesDocumentDTO) {
        return Mono.just(moviesDocumentDTO)
                .filter(validationEmptyField -> Objects.nonNull(validationEmptyField.getTitle()) && !moviesDocumentDTO.getTitle().isBlank())
                .filter(validationEmptyField -> Objects.nonNull(validationEmptyField.getDirector()) && !moviesDocumentDTO.getDirector().isBlank())
                .filter(moviesDocumentDTO1 -> moviesDocumentDTO1.getRating() >= 1 && moviesDocumentDTO1.getRating() <= 5)
                .flatMap(validationEmptyField -> movieRepository.save(movieMapper.mapperToMovie(validationEmptyField.getId()).apply(validationEmptyField))
                        .map(moviesDocument -> validationEmptyField))
                .switchIfEmpty(Mono.defer(()->Mono.error( new CinemaException(CinemaErrorEnum.REQUEST_NOT_FOUND))));
    }
}
