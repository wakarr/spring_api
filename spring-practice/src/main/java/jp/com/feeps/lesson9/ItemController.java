package jp.com.feeps.lesson9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

	@Autowired
	ItemRepository repository;
	
	@GetMapping("/item/findAll")
	public String findAll(Model model) {
		List<Item>itemList = repository.findAll();
		model.addAttribute("itemList", itemList);
		
		return "lesson9/item_list";
	}
	
	@GetMapping("/item/findOne/{id}")
	public String findOne(@PathVariable int id, Model model) {
		Item item  = repository.getById(id);
		model.addAttribute("item", item);
		return "lesson9/item";
	}
	
	@GetMapping("/item/findPrice/{price}")
	public String findPrice(@PathVariable int price, Model model) {
		List<Item> itemList = repository.findByPrice(price);
		model.addAttribute("itemList", itemList);
		return "lesson9/item_list";
	}
	
	@GetMapping("/item/registInput")
	public String registInput() {
		return "lesson9/regist_input";
	}
	
	@PostMapping("/item/registComplete")
	public String registComplete(ItemForm itemForm) {
		Item item = new Item();
		item.setId(itemForm.getId());
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		repository.save(item);
		
		return "redirect:/item/findAll";
	}
	
	@GetMapping("/item/updateInput")
	public String updateInput() {
		return "lesson9/update_input";
	}
	
	@PostMapping("/item/updateComplete")
	public String updateComplete(ItemForm itemForm) {
		Item item = new Item();
		item.setId(itemForm.getId());
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		repository.save(item);
		
		return "redirect:/item/findAll";
	}
	
	@GetMapping("/item/deleteInput")
	public String deleteInput() {
		return "lesson9/delete_input";
	}
	
	@PostMapping("/item/deleteComplete")
	public String deleteComplete(int id) {
		repository.deleteById(id);
		return "redirect:/item/findAll";
	}
	
	
	
}
