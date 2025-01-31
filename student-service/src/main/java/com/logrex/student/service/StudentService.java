package com.logrex.student.service;


import com.logrex.student.Response.StudentDTO;
import com.logrex.student.entity.Student;
import com.logrex.student.feignclients.AddressFeignClients;
import com.logrex.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressFeignClients addressFeignClients;

    public StudentDTO getById (long id) {

        Optional<Student> students = studentRepository.findById(id);

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(students.get().getId());
        studentDTO.setFirstName(students.get().getFirstName());

        studentDTO.setLastName(students.get().getLastName());
        studentDTO.setEmail(students.get().getEmail());

        studentDTO.setAddressDTO(addressFeignClients.getById(students.get().getAddressId()));

        return studentDTO;
    }
}
