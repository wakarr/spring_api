package jp.com.feeps.lesson4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Forward {

	@GetMapping("/source")
	public String source() {
		return "forward:/distination";
	}
	
	@GetMapping("/distination")
	public String distination() {
		return "lesson4/forward";
	}
	
}
