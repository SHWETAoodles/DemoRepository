package com.Emp.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	public class ViewController {
	   @RequestMapping("/locale")
	   public String locale() {
		   System.out.println("in the locale method");
	      return "locale";
//	     this is comment
	   }
	}


