package eu.kolohnat.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;  // https://projectlombok.org/features + Install Lombok plugin for IntelliJ
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
