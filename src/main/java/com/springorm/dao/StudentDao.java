package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entity.Student;

public class StudentDao  implements StudentDaoInterface{
     
	HibernateTemplate hibernateTemplate;
      
      
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//constructor
	public StudentDao() {
		super();
	}
	// insert operation
	@Transactional
	public int insert(Student student) {
		int result=(Integer) hibernateTemplate.save(student);
		return result;
	}
	// get particular student object by it Operation
	public Student getStudent(int id) {
		Student s=hibernateTemplate.get(Student.class, id);
		return s;
	}
	//  get all student objects in list operation
	public List<Student> getAllStudents() {
		List<Student> s=hibernateTemplate.loadAll(Student.class);
		return s;
	}
	
	  // delete particular student operation
	@Transactional
	public void delete(int id) {
		Student student=hibernateTemplate.get(Student.class,id);
		hibernateTemplate.delete(student);
		
	}
	 // update Operation 
	@Transactional
	public void updateStudent(Student student) {
		 hibernateTemplate.update(student);
	}

}
