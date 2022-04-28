package jp.com.feeps.lesson10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemView {

	@GetMapping("/itemInfo")
	public String itemView() {
		return "lesson10/item_info";
	}
}
