package com.example.Repaso_CRUD.mapper;

import com.example.Repaso_CRUD.collections.UserDocument;
import com.example.Repaso_CRUD.dto.UserDocumentDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {

    // UserDocumentDTO a UserDocument
    public Function<UserDocumentDTO, UserDocument> mapperToUser(String id){
        return updateUser -> {
            var user = new UserDocument();
            user.setId(id);
            user.setName(updateUser.getName());
            user.setLastname(updateUser.getLastname());
            return user;
        };

    }

    // UserDocument a UserDocumentDTO
    public Function<UserDocument, UserDocumentDTO> mapMovieToDTO() {
        return entity -> new UserDocumentDTO(entity.getId(),
                entity.getName(),
                entity.getLastname());
    }
}
