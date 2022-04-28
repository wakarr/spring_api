package jp.com.feeps.lesson2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class index {
	
	@GetMapping("/")
	@PostMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/")
	public String index2() {
		return "index";
	}
	
	@RequestMapping(path="", method= {RequestMethod.POST, RequestMethod.GET})
	public String index3() {
		return "index";
	}
	
	
}