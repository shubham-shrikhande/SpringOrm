package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputFilter.Config;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entity.Student;

import java.util.*;

public class Test {
	public static void main(String[]args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/springorm/config.xml");
		StudentDao dao=(StudentDao) context.getBean("dao");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Student student=new Student();
		boolean go=true;
		while(go) {
			System.out.println("Enter 1 to add new Student info");
			System.out.println("Enter 2 to display all students");
			System.out.println("Enter 3 to get details of single student");
			System.out.println("Enter 4 to delete students");
			System.out.println("Enter 5 to update students");
			System.out.println("Enter 6 to exit");
			try {
				int input=Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					System.out.println("Enter Id");
					int id=Integer.parseInt(br.readLine());
					student.setId(id);
					System.out.println("Enter Id");
					student.setName(br.readLine());
					System.out.println("Enter Id");
					student.setCity(br.readLine());
				    int i=dao.insert(student);
				    System.out.println("Student saved"+i);
					break;

				case 2:
					System.out.println("Enter Id");
					int id1=Integer.parseInt(br.readLine());
					Student s=dao.getStudent(id1);
					System.out.println("Student name "+s.getName()+"Student city "+s.getCity());
					break;
					
				case 3:
				     List<Student> students=dao.getAllStudents();
				     for(Student s1:students) {
				    	 System.out.println("Student Id"+s1.getId());
				    	 System.out.println("Student Name"+s1.getName());
				    	 System.out.println("Student city"+s1.getCity());
				     }
					break;
				case 4:
					System.out.println("Enter id");
					int id3=Integer.parseInt(br.readLine());
					dao.delete(id3);
					System.out.println("Student deleted successfully");
					break;
			
				case 5:
					
					go=false;
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();

			}
			
          System.out.println("Thank you!! Visit Again");
		}
	}}
