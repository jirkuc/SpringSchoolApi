package eu.kolohnat.school.service;

import eu.kolohnat.school.dto.SubjectDto;
import eu.kolohnat.school.entity.SubjectEntity;
import eu.kolohnat.school.mapper.SubjectMapper;
import eu.kolohnat.school.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectDto> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjectDtos.add(subjectMapper.toDto(subjectEntity));
        }
        return subjectDtos;
    }

    public SubjectDto getSubject(Integer id) {
        SubjectEntity subjectEntity = subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        // SubjectEntity subjectEntity = subjectRepository.getReferenceById(id);  //alternative method look for an item by id
        return subjectMapper.toDto(subjectEntity);
    }

    public SubjectDto addSubject(SubjectDto subjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        SubjectEntity savedSubjectEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto((savedSubjectEntity));
    }

    public SubjectDto editSubject(Integer id, SubjectDto subjectDto) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        subjectEntity.setId(id);
        SubjectEntity savedSubjectEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(savedSubjectEntity);
    }

    public SubjectDto deleteSubject(Integer id) {
        SubjectEntity subjectToDelete = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        SubjectDto deletedSubject = subjectMapper.toDto(subjectToDelete);
        subjectRepository.delete(subjectToDelete);
        return deletedSubject;
    }
}
