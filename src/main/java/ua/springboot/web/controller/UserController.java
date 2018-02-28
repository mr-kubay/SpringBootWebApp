package ua.springboot.web.controller;

import java.io.File;

import javax.persistence.MappedSuperclass;
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
	public String showAddUserForm(Model model) {
		model.addAttribute("userModel", new User());
		return "user/create";
	}
	
	@PostMapping("/create")
	public String showAddUserFormPost(@ModelAttribute("userModel") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/create";
		}
			System.out.println("asdff");
			String rootPath = System.getProperty("user.dir");
			userService.saveUser(user);

			File uploadDir = new File(rootPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "user_" + user.getId());
			if(!uploadDir.exists()) {
				uploadDir.mkdir();
			}
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String showloginPage(Model model) {
		
		model.addAttribute("userModel", new User());
		return "user/login";
	}
	
	@PostMapping("/login")
	public String postLoginPage(@ModelAttribute("userModel") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/login";
		}
		return "redirect:/";
	}
}
