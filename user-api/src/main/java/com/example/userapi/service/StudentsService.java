package com.example.userapi.service;

import com.example.userapi.entity.Students;
import com.example.userapi.exception.CustomerException;
import com.example.userapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;

        public Students studentData(Long id) {
            return studentRepository.findById(id)
                    .orElseThrow(() -> new CustomerException(
                            "Student not found: " + id,
                            HttpStatus.NOT_FOUND));
    }
}
