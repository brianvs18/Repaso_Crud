package com.example.Repaso_CRUD.usecase.user;

import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.mapper.UserMapper;
import com.example.Repaso_CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public CreateUserUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Mono<UserDocumentDTO> createUser(UserDocumentDTO userDocumentDTO) {
        return Mono.just(userDocumentDTO)
                .filter(validationEmptyField -> Objects.nonNull(validationEmptyField.getName()))
                .filter(validationEmptyField -> Objects.nonNull(validationEmptyField.getLastname()))
                .flatMap(saveUserDocument -> userRepository.save(userMapper.mapperToUser(saveUserDocument.getId()).apply(saveUserDocument))
                        .map(userDocument -> saveUserDocument));
    }
}
