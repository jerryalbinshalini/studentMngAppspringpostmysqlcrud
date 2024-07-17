package com.studentmanagement.StudentMagmtApp.service;

import com.studentmanagement.StudentMagmtApp.entity.Student;
import com.studentmanagement.StudentMagmtApp.request.StudentRequest;

public interface StudentService {
    public Student savestudent(StudentRequest studentRequest);
    public Student getstudent(Long id);
    public Student updatestudent(Long id, StudentRequest studentRequest);
    public String  deletestudent(Long id);
}
