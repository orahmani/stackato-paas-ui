package com.poalim.paas.mngr.ui;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		//model.put("time", new Date());
		//model.put("message", this.message);
		return "index";
	}

}
