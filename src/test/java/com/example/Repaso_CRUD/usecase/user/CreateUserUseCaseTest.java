package com.example.Repaso_CRUD.usecase.user;

import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import com.example.Repaso_CRUD.mapper.UserMapper;
import com.example.Repaso_CRUD.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserUseCaseTest {

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private final UserDocumentDTO userDocumentDTO = new UserDocumentDTO();
}