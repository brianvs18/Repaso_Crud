package com.example.Repaso_CRUD.usecase.user;

import com.example.Repaso_CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DeleteUserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<Void> deleteUserById(String id){
        return userRepository.deleteById(id);
    }
}
