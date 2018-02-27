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

import ua.springboot.web.entity.Car;
import ua.springboot.web.service.CarService;
import ua.springboot.web.service.ColorService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	
	private CarService carService;
	private ColorService colorService;
	
	
	@Autowired
	public CarController(CarService carService, ColorService colorService) {
		this.carService = carService;
		this.colorService = colorService;
	}

	@GetMapping("/create")
	public String showAddCarForm(Model model) {
		model.addAttribute("carModel", new Car());
		model.addAttribute("colorsList", colorService.findAllColors());
		return "car/create";
	}
	
	@PostMapping("/create")
	public String showAddCarFormPost(@ModelAttribute("carModel") @Valid Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "car/create";
		}
		carService.saveCar(car);
		return "redirect:/";
	}
}