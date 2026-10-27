package com.example.userapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class CustomerRequest {
    @NotNull
    private String name;
    @NotNull 
    private String email;
}