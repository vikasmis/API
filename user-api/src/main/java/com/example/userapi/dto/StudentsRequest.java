package com.example.userapi.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StudentsRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
}
