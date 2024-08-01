package eu.kolohnat.school.mapper;

import eu.kolohnat.school.dto.SubjectDto;
import eu.kolohnat.school.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto subjectDto);
    SubjectDto toDto(SubjectEntity subjectEntity);
}
