package eu.kolohnat.school.mapper;

import eu.kolohnat.school.dto.GradeDto;
import eu.kolohnat.school.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface GradeMapper {
    GradeEntity toEntity(GradeDto gradeDto);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    GradeDto toDto(GradeEntity gradeEntity);

    GradeEntity updateEntity(GradeDto gradeDto, @MappingTarget GradeEntity gradeEntity);
}
