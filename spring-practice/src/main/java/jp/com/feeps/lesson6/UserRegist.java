package jp.com.feeps.lesson6;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegist {
	
	@GetMapping("/inputUser")
	public String inputUser(UserForm userForm, Model model) {
		model.addAttribute("userForm", userForm);
		return "lesson6/input_user";
	}

	@PostMapping("/userRegist")
	public String userRegist(@Valid UserForm userForm, BindingResult result, Model model){
		model.addAttribute("userForm", userForm);
		
		if(result.hasErrors()) {
			return "lesson6/input_user";
		}else {
			return "lesson6/output_user";
		}
	}
	
}
