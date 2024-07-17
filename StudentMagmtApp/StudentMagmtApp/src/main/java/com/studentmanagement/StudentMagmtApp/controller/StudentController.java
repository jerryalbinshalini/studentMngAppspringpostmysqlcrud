package com.studentmanagement.StudentMagmtApp.controller;

import com.studentmanagement.StudentMagmtApp.entity.Student;
import com.studentmanagement.StudentMagmtApp.request.StudentRequest;
import com.studentmanagement.StudentMagmtApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest studentRequest){
        Student student=studentService.savestudent(studentRequest);
        if (student!=null){
            return new ResponseEntity<>("Student added", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getstudent(id);
    }

    @PutMapping("update/{id}")
    public Student updateStudent(@RequestBody StudentRequest studentRequest,@PathVariable Long id){
        return studentService.updatestudent(id,studentRequest);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deletestudent(id);
    }

}
