package jp.com.feeps.lesson4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect {

	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/source";
	}

}
