package com.Emp.training.aopDemo;

import org.springframework.stereotype.Component;

@Component
public class Student {
public int  studyCourse(int x, int y) {
	System.out.println("I am going to study for completing my course");
	return 500;
	
}
public String doOperation() {
	throw new MyException("this is my exception.....");
}
public int rankOfVideo(int noOfViews,int watchtime ) {
	System.out.println("this is rank method......"+noOfViews +"________"+watchtime);
return	(noOfViews*watchtime)-(noOfViews+watchtime);
}
}
