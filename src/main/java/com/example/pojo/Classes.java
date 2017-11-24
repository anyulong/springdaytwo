package com.example.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.pojo.Student;


public class Classes {
	
	List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

//	public Classes() {
//	
//		this.students=new ArrayList<>();
//		this.students.add(new Student());
//		for(int i=0;i<100;i++) {
//			this.students.add(new Student());
//			this.students.get(i).setId(i);
//			this.students.get(i).setName("张三"+i);
//			this.students.get(i).setScore((int)(Math.round(Math.random()*3)*5+85));
//		}
//		
//	}
	

	@Override
	public String toString() {
		return "Classes [students=" + students + "]";
	}

	public Classes(List<Student> students) {
		
		this.students = students;
	}

	
	
}
