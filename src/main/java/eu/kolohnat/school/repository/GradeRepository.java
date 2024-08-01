package eu.kolohnat.school.repository;

import eu.kolohnat.school.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<for which entity, primary key type>
public interface GradeRepository extends JpaRepository<GradeEntity, Integer> {
}
