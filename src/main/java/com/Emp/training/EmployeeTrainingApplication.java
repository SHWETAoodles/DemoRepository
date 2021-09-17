package com.Emp.training;


//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;


//import com.Emp.training.aopDemo.Person;
import com.Emp.training.aopDemo.Student;
//import com.Emp.training.service.EmailSenderService;




@SpringBootApplication
public class EmployeeTrainingApplication {


	public static void main(String[] args) {
		
//		SpringApplication.run(EmployeeTrainingApplication.class, args);}
		
	ConfigurableApplicationContext	con=SpringApplication.run(EmployeeTrainingApplication.class, args);
	Student st=con.getBean("student",Student.class);
//	int val=st.studyCourse(65,5);
//	System.out.println("return value from method : "+val);
//	st.doOperation();
	//Person pr=con.getBean("person",Person.class);
	//pr.studyGk();
int rank=st.rankOfVideo(100, 65);
System.out.println("video ranking position is :"+rank);}


}



	














	


