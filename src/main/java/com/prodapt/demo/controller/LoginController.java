package com.prodapt.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.demo.entity.User;
import com.prodapt.demo.entity.UserDetails;
import com.prodapt.demo.exceptions.InvalidCredentialsException;
import com.prodapt.demo.service.UserService;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(Model model){
        // create model object to store form data
        UserDetails logout = new UserDetails();
        model.addAttribute("logout", logout);
        return "logout";
    }


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDetails user = new UserDetails();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration( @ModelAttribute("user") UserDetails userDetails,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDetails.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDetails);
            return "/register";
        }

        userService.saveUser(userDetails);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDetails> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/showUpdatedUserDetails/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") Long id, Model model) {
		
		// get employee from the service
		User user = userService.getUserDetailsById(id);
	
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("updateduser", user);
		return "updateuser";
	}
    @GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") Long id) {
		
		// call delete employee method 
		this.userService.deleteUserDetailsById(id);
		return "redirect:/";
	}
 
}