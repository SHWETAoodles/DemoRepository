package com.Emp.training.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.training.model.EmailRequest;
import com.Emp.training.service.EmailService;

@RestController
public class Welcome {
	@Autowired
	private EmailService emailService;
	@RequestMapping("/welcome")
	public String welcome() {
		return "this is mail API";
	}
	//api to send email
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		boolean result=this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
	if(result) {
		return ResponseEntity.ok("email is sent successfully........");
	}
	else {
	return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email not sent..........");
	}
	
	}

}
