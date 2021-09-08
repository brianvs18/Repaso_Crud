package com.example.Repaso_CRUD.mapper;

import com.example.Repaso_CRUD.collections.MoviesDocument;
import com.example.Repaso_CRUD.dto.MoviesDocumentDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MovieMapper {

    // Funcion para convertir de MovieDocumentDTO a MovieDocument
    public Function<MoviesDocumentDTO, MoviesDocument> mapperToMovie(String id) {
        return updateMovie -> {
            var movie = new MoviesDocument();
            movie.setId(id);
            movie.setTitle(updateMovie.getTitle());
            movie.setDirector(updateMovie.getDirector());
            movie.setRating(updateMovie.getRating());
            return movie;
        };

    }

    // Funcion para convertir de MovieDocument a MovieDocumentDTO
    public Function<MoviesDocument, MoviesDocumentDTO> mapMovieToDTO() {
        return entity -> new MoviesDocumentDTO(entity.getId(),
                entity.getTitle(),
                entity.getDirector(),
                entity.getRating()
        );
    }
}
