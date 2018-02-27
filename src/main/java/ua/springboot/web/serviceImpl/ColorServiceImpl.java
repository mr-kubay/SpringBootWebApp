package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Color;
import ua.springboot.web.repository.ColorRepository;
import ua.springboot.web.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{

	@Autowired
	private ColorRepository colorRep;
	
	@Override
	public List<Color> findAllColors() {
		return colorRep.findAll();
	}

}
