package practice.springmvcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping("/")
	public String getDefaultView() {
		return "menu";
	}
	
	@RequestMapping("/menu")
	public String getMenuView() {
		return "menu";
	}

}
