package com.example.userapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "music")
@Getter
@Setter
public class MusicItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instrument;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("instrument")
    private Customer customer;
}
