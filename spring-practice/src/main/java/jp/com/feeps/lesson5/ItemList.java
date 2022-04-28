package jp.com.feeps.lesson5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemList {

	@GetMapping("/list")
	public String list(Model model) {
		List<String>itemList = new ArrayList<>();
		itemList.add("アーモンド");
		itemList.add("クルミ");
		itemList.add("カシューナッツ");
		
		model.addAttribute("itemList", itemList);
		return "lesson5/item_list";
	}
}
