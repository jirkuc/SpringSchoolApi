package eu.kolohnat.school.controller;

import eu.kolohnat.school.dto.GradeDto;
import eu.kolohnat.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @GetMapping({"/grades", "/grades/"})
    public List<GradeDto> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDto getGradeById(@PathVariable int gradeId) {
        return gradeService.getGradeById(gradeId);
    }

    @PostMapping({"/grades", "/grades/"})
    public GradeDto addGrade(@RequestBody GradeDto gradeDto) {
        return gradeService.addGrade(gradeDto);
    }

    @PutMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDto editGrade(@PathVariable int gradeId, @RequestBody GradeDto gradeDto) {
        return gradeService.editGrade(gradeId, gradeDto);
    }
    @DeleteMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDto deleteGrade(@PathVariable int gradeId){
        return gradeService.deleteGrade(gradeId);
    }
}
