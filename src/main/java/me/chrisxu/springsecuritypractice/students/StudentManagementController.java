package me.chrisxu.springsecuritypractice.students;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final Logger log = LoggerFactory.getLogger(StudentManagementController.class);

    private static final List<Student> students = Arrays.asList(
            new Student(1, "Chris"),
            new Student(2, "Jenny"),
            new Student(3, "William"),
            new Student(4, "Echo")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        log.info(String.format("Register %s", student));
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        log.info(String.format("Delete student %s", studentId));
    }

    @PutMapping("{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student newStudent) {
        log.info(String.format("Update student %s", studentId));
    }

}
