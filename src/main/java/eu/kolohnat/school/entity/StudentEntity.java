package eu.kolohnat.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "student")
@Getter
@Setter
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(length=255)   //field length specification
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    // @OneToMany
    // List<GradeEntity> grades;
}
