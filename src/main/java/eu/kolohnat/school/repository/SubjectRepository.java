package eu.kolohnat.school.repository;

import eu.kolohnat.school.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    Optional<SubjectEntity> findByName(String name);  // custom method to look for a subject entity by name
}
