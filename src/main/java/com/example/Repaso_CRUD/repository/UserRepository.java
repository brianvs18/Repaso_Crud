package com.example.Repaso_CRUD.repository;

import com.example.Repaso_CRUD.collections.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserDocument, String> {
}
