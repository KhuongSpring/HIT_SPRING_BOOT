package com.example.demo.services.impls;

import com.example.demo.models.dtos.requests.StudentCreationRequest;
import com.example.demo.models.dtos.responses.StudentResponse;
import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {

    StudentRepository studentRepository;
    ModelMapper modelMapper;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean addStudent(StudentCreationRequest request) {
        if (studentRepository.existsByEmail((request.getEmail()))) return false;
        studentRepository.save(modelMapper.map(request, Student.class));
        return true;
    }

    @Override
    public StudentResponse editStudent(Long id) {

        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id))
            return false;
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentResponse> searchStudent(Long id, String name, Long class_id) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        if (id != null) {
            studentResponses.add(modelMapper.map(studentRepository.findById(id), StudentResponse.class));
        } else if (name != null) {
            studentResponses.add(modelMapper.map(studentRepository.findByName(name), StudentResponse.class));
        } else {
            List<Student> students = getStudents();
            for(Student s : students){
                if (s.getClasses().getId().equals(class_id)) studentResponses.add(modelMapper.map(students, StudentResponse.class));
            }
        }
        return studentResponses;
    }
}
