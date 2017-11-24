package com.example.service;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.pojo.Classes;
import com.example.pojo.Student;

@Service
public class StudentService {
	
	//学生签到
	public void sign(Classes classes) {
		System.out.println("请输入学号");
		Scanner sc  = new Scanner(System.in);
		int id = sc.nextInt();
		List<Student> signStudent = checkStudent(classes.getStudents(), s->s.getId()==id);
		if(signStudent.isEmpty()) {
			System.out.println("非本班人员");
		}else{	
			signStudent.get(0).setSign(true);
			System.out.println("签到成功");
		};
	}
	
	//签到与未签到的学生
	public List<Student> selectStudent(Classes classes,boolean sign) {
		List<Student> student = checkStudent(classes.getStudents(), s->s.isSign()==sign);
		if(student.isEmpty()) {
			System.out.println("无人");
		}else {
			System.out.println(student);
		}
		return student;
	}
	
	//统计学生人数
	public int countStudent(Classes classes,boolean sign) {
		int count = checkStudent(classes.getStudents(), s->s.isSign()==sign).size();
		System.out.println("有"+count+"人");
		return count;
	}
	
	public static <T> List<T> checkStudent(List<T> students, Predicate<T> pre){
		return students.stream().filter(pre).collect(Collectors.toList());
	}
}
