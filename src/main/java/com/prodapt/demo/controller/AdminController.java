package com.prodapt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.demo.entity.User;
import com.prodapt.demo.entity.UserDetails;
import com.prodapt.demo.exceptions.InvalidCredentialsException;
import com.prodapt.demo.service.UserDetailsService;
import com.prodapt.demo.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/home")
	public String showAdminForm(@ModelAttribute("user") User user) {
		return "home";
	}

	@GetMapping("/update")
	public String showUpdateForm(@ModelAttribute("user") User user , @ModelAttribute("userdetails") UserDetails userdetails) {
		return "update";
	}
	
	@PutMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute ("user") User user , @ModelAttribute ("userdetails") UserDetails userdetails) {
		
		ModelAndView mv = new ModelAndView();
		user.setUserDetails(userdetails);
		User userData = userService.updateUser(user);
		mv.setViewName("update");
		mv.addObject("updatedData", userData);
		
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute ("user") User user ) {
		return "delete";
		}
	
	@DeleteMapping("/deleteuser")
	public ModelAndView deleteUser(@ModelAttribute("user") User user) {
		
		userService.deleteUserById(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		mv.addObject("msg", " User Successfully Deleted" );
		
		return mv;
		
	}
	@PostMapping("/adminlogin")
	public ModelAndView loginAdmin(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("adminlogged");
		} catch (InvalidCredentialsException e) {
			mv.addObject("errormsg", "Username or Password incorrect");
			mv.setViewName("admin");
		}

		return mv;
	}

	@GetMapping("/admin")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "admin";
	}

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("userdetails") UserDetails userdetails) {
		ModelAndView mv = new ModelAndView();

		List<UserDetails> users =  userDetailsService.getList();
		mv.setViewName("list");
		mv.addObject("listOfUsers", users);
		return mv;
	}

//	@GetMapping("/list")
//	public ModelAndView list( @ModelAttribute("userdetails") UserDetails userdetails) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("list");
//		mv.addObject("listOfUsers", userService.getList());
//		return mv;
//	}

}