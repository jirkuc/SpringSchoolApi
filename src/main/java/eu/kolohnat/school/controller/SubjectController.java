package eu.kolohnat.school.controller;

import eu.kolohnat.school.dto.SubjectDto;
import eu.kolohnat.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping({"/subjects", "/subjects/"})
    public List<SubjectDto> getStudents() {
        return subjectService.getSubjects();
    }

    @GetMapping({"/subjects/{id}", "/subjects/{id}/"})
    public SubjectDto getSubject(@PathVariable Integer id) {
        return subjectService.getSubject(id);
    }

    @PostMapping({"/subjects", "/subjects/"})
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }

    @PutMapping({"/subjects/{id}", "/subjects/{id}/"})
    public SubjectDto editSubject(@PathVariable Integer id, @RequestBody SubjectDto subjectDto) {
        return subjectService.editSubject(id, subjectDto);
    }

    @DeleteMapping({"/subjects/{id}", "/subjects/{id}/"})
    public SubjectDto deleteSubject(@PathVariable Integer id) {
        return subjectService.deleteSubject(id);
    }
}
