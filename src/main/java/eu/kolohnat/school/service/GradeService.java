package eu.kolohnat.school.service;

import eu.kolohnat.school.dto.GradeDto;
import eu.kolohnat.school.entity.GradeEntity;
import eu.kolohnat.school.mapper.GradeMapper;
import eu.kolohnat.school.repository.GradeRepository;
import eu.kolohnat.school.repository.StudentRepository;
import eu.kolohnat.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<GradeDto> getAllGrades() {
        List<GradeDto> allGrades = new ArrayList<>();
        for (GradeEntity gradeEntity : gradeRepository.findAll()) {
            allGrades.add(gradeMapper.toDto(gradeEntity));
        }
        return allGrades;
    }

    public GradeDto getGradeById(int gradeId) {
        return gradeMapper.toDto(gradeRepository.getReferenceById(gradeId));
    }

    public GradeDto addGrade(GradeDto gradeDto) {
        GradeEntity gradeToAdd = gradeMapper.toEntity(gradeDto);
        gradeToAdd.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        gradeToAdd.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        return gradeMapper.toDto(gradeRepository.save(gradeToAdd));
    }

    public GradeDto editGrade(int gradeId, GradeDto gradeDto) {
        gradeDto.setId(gradeId);
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        gradeMapper.updateEntity(gradeDto, gradeEntity);
        gradeEntity.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeEntity.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        return gradeMapper.toDto(gradeRepository.save(gradeEntity));
    }

    public GradeDto deleteGrade(int gradeId) {
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        GradeDto deletedGrade = gradeMapper.toDto(gradeEntity);
        gradeRepository.delete(gradeEntity);
        return deletedGrade;
    }
}
