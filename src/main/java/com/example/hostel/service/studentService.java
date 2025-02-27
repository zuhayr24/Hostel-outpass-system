package com.example.hostel.service;

import com.example.hostel.model.Student;
import com.example.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student login(String username, String password) {
        Optional<Student> student = studentRepository.findById(username);
        return student.filter(w -> w.getPassword().equals(password)).orElse(null);
    }
}
