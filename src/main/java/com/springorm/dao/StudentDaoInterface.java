package com.springorm.dao;

import java.util.List;

import com.springorm.entity.Student;

public interface StudentDaoInterface {
   public int insert(Student student);
   public Student getStudent(int id);
   public List<Student> getAllStudents();
   public void delete(int id);
   public void updateStudent(Student student);
}
