package com.example.Repaso_CRUD.usecase.user;

import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.mapper.UserMapper;
import com.example.Repaso_CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ListUsersUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public ListUsersUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Flux<UserDocumentDTO> findAllUsers(){
        return userRepository.findAll().map(userMapper.mapMovieToDTO());
    }

    public Mono<UserDocumentDTO> findUserById(String userId){
        return userRepository.findById(userId).map(userMapper.mapMovieToDTO());
    }
}
