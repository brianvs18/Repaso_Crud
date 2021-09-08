package com.example.Repaso_CRUD.repository;

import com.example.Repaso_CRUD.collections.MoviesDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<MoviesDocument, String> {
}
