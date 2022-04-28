package jp.com.feeps.lesson9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemJoinCategoryController {

	@Autowired
	ItemJoinCategoryRepository repository;
	
	@GetMapping("/itemJoinCategory/findAll")
	public String findAll(Model model) {
		List<ItemJoinCategory> itemJoinCategoryList = repository.findAll();
		model.addAttribute("itemJoinCategoryList", itemJoinCategoryList);
		return "lesson9/item_join_category_list";
	}
	
	@GetMapping("/itemJoinCategory/priceInput")
	public String priceInput() {
		return "lesson9/price_input";
	}
	
	@PostMapping("/itemJoinCategory/findByPriceGeInputPrice")
	public String priceGeSearch(int price, Model model) {
		List<ItemJoinCategory> itemJoinCategoryList = repository.findByPriceGreaterThanEqualInputPriceQuery(price);
		model.addAttribute(itemJoinCategoryList);
		return "lesson9/item_join_category_list";
	}
}
