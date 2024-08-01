package eu.kolohnat.school.service;

import eu.kolohnat.school.dto.StudentDto;
import eu.kolohnat.school.entity.StudentEntity;
import eu.kolohnat.school.mapper.StudentMapper;
import eu.kolohnat.school.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            studentDtos.add(studentMapper.toDto(studentEntity));
        }
        return studentDtos;
    }

    public StudentDto getStudent(Integer id) {
        // Optional<StudentEntity> studentEntity = studentRepository.findById(id);

        StudentEntity studentEntity = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
//        if (!studentRepository.existsById(id)) {
//            throw new EntityNotFoundException();
//        }
//        StudentEntity studentEntity = studentRepository.getReferenceById(id);
        return studentMapper.toDto(studentEntity);
    }

    public StudentDto addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudentEntity);
    }

    public StudentDto editStudent(Integer id, StudentDto studentDto) {
//        StudentEntity studentToEdit = studentRepository
//                .findById(id)
//                .orElseThrow(EntityNotFoundException::new);
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        studentEntity.setId(id);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudentEntity);
    }

    public StudentDto deleteStudent(Integer id) {
        StudentEntity studentToDelete = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        StudentDto deletedStudent = studentMapper.toDto(studentToDelete);
        studentRepository.delete(studentToDelete);
        return deletedStudent;
    }
}
