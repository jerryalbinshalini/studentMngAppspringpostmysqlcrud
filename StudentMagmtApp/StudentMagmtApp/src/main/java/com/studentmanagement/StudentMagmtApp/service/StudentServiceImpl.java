package com.studentmanagement.StudentMagmtApp.service;

import com.studentmanagement.StudentMagmtApp.entity.Student;
import com.studentmanagement.StudentMagmtApp.repository.StudentRepository;
import com.studentmanagement.StudentMagmtApp.request.StudentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student savestudent(StudentRequest studentRequest) {
        Student student=new Student();
        student.setId(studentRequest.getId());
        student.setName(studentRequest.getName());
        student.setBranch(studentRequest.getBranch());
        return studentRepository.save(student);
    }

    @Override
    public Student getstudent(Long id) {
        Optional<Student> stu=studentRepository.findById(id);
        if (stu.isPresent()){
            return stu.get();
        }
        else {
            new Student();
        }
        return null;
    }

    @Override
    public Student updatestudent(Long id, StudentRequest studentRequest) {
        Student student = new Student();
        if (studentRequest.getId() != 0) {
            Optional<Student> stu = studentRepository.findById(studentRequest.getId());
            if (stu.isPresent()) {
                student = stu.get();

            } else {
                student = new Student();
            }


        }
//        student.setId(studentRequest.getId());
//        student.setName(studentRequest.getName());
//        student.setBranch(studentRequest.getBranch());

        BeanUtils.copyProperties(studentRequest, student);
        return studentRepository.save(student);
    }

    @Override
    public String deletestudent(Long id) {
        Optional<Student> stu=studentRepository.findById(id);
        if (stu.isPresent()){
            Student student=stu.get();
            studentRepository.delete(student);
        }
        return "deleted successfully";
    }
}
