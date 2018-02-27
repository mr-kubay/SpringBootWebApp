package ua.springboot.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import ua.springboot.web.entity.Color;

public class ColorFormatter implements Formatter<Color>{

	@Override
	public String print(Color object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Color parse(String text, Locale locale) throws ParseException {
		int id = Integer.valueOf(text);
		Color color = new Color();
		color.setId(id);
		return color;
	}

}
