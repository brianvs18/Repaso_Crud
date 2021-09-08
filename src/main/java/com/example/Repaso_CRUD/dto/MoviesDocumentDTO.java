package com.example.Repaso_CRUD.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDocumentDTO {

    private String id;
    private String title;
    private String director;
    private Integer rating;
}
