package com.example.userapi.controller;

import com.example.userapi.entity.Students;
import com.example.userapi.service.StudentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping("/{id}")
    public ResponseEntity<Students> studentData(@PathVariable Long id) {
        return ResponseEntity.ok(studentsService.studentData(id));
    }
}
