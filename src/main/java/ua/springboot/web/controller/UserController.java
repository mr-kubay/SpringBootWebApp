package ua.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.entity.User;
import ua.springboot.web.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/create")
	public String showAddCarForm(Model model) {
		model.addAttribute("userModel", new User());
		return "user/create";
	}
	
	@PostMapping("/create")
	public String showAddCarFormPost(@ModelAttribute("userModel") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/create";
		}
		userService.saveUser(user);
		return "redirect:/";
	}
}
