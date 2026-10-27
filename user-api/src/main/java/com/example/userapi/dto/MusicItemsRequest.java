package com.example.userapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicItemsRequest {
     @NotNull(message = "Customer ID Missing")
     @Positive(message = "Customer ID must be positive")
     private Long customerId;
     @NotBlank(message = "Instrument Missing")
     private String instrument;

}
