package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.user;
import com.example.demo.services.userservice;

import jakarta.servlet.http.HttpSession;


@Controller
public class usercontroller {
	@Autowired
	userservice userservice;
	@PostMapping("/register")
	public String adduser(@ModelAttribute user usr) {
		boolean userstates=userservice.emailexit(usr.getEmail());
		if(userstates==false) {
			userservice.adduser(usr);
			System.out.println("user add");
		}
		else {
			System.out.println("user already exit");
		}
		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password,HttpSession session,Model model) {
		if(userservice.validateuser(email,password)==true) {
			String role=userservice.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin"))
			{
				return "adminhome";
			}else {
				user user=userservice.getUser(email);
				boolean userstatus=user.isIspremium();
				model.addAttribute("ispremium", userstatus);
                return "customerhome";
			}
		}

		else {
			return"login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"login";
	}

}
