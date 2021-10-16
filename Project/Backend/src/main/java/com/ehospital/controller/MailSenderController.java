package com.ehospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.pojos.EmailStructure;

import com.ehospital.service.EmailSenderService;

@RestController
public class MailSenderController {

	@Autowired
	private EmailSenderService emailSender;
	
	public MailSenderController() {
		System.out.println("in ctor of " + getClass().getName());

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/sendemail")
	public void sendEmail(@RequestBody EmailStructure es) {
		System.out.println();
		System.out.println("in send mail ");
		emailSender.sendHtmlMail(es);
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/otp/{eotp}")
	public String verifyOtp(@PathVariable String eotp) {
		System.out.println("in verify otp");
		return emailSender.verifyOtp(eotp);
	}
}
