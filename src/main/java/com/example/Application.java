package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pojo.Classes;
import com.example.pojo.Student;
import com.example.service.MathService;
import com.example.service.StudentService;

@SpringBootApplication
public class Application {
	@Autowired
	private StudentService ss;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			List<Student> students=new ArrayList<Student>();
			for(int i=0;i<100;i++) {
			students.add(new Student());
			students.get(i).setId(i);
			students.get(i).setName("张三"+i);
			students.get(i).setScore((int)(Math.round(Math.random()*3)*5+85));
			}
			Classes classes = new Classes(students);
			System.out.println("欢迎！");
			while(true) {
				System.out.println("1.签到     2.查询签到学生    3.统计人数      4.退出");
				
				Scanner sc  = new Scanner(System.in);
				int num = sc.nextInt();
				switch (num) {
				case 1:
					ss.sign(classes);
					break;
				case 2:
					ss.selectStudent(classes, true);
					break;	
				case 3:
					ss.countStudent(classes, true);
					break;
				case 4:
					System.out.println("退出了");
					return;
				default:
					break;
				}
			}
		};
	}
	
}