package com.example.Repaso_CRUD.router;

import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.example.Repaso_CRUD.usecase.movies.CreateMovieUseCase;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateMoviesRouter {

    @Bean
    public RouterFunction<ServerResponse> createMovies(CreateMovieUseCase createMovieUseCase){
        return route(POST("/movies").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(MoviesDocumentDTO.class)
                        .flatMap(moviesDocumentDTO -> createMovieUseCase.createMovie(moviesDocumentDTO)
                            .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result))
                        )
                );
    }
}
