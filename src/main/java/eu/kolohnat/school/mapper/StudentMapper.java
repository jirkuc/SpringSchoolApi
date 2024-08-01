package eu.kolohnat.school.mapper;

import eu.kolohnat.school.dto.StudentDto;
import eu.kolohnat.school.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(StudentDto studentDto);
    StudentDto toDto(StudentEntity studentEntity);
}
