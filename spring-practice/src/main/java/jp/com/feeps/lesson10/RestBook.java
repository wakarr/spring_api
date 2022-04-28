package jp.com.feeps.lesson10;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restBookInfo")
public class RestBook {

	@GetMapping
	public List<String> getBookList(){
		List<String> bookList = new ArrayList<>();
		bookList.add("えんとつ町のパピプ");
		bookList.add("はらぺこてんとうむし");
		bookList.add("らっこたいそう");
		
		return bookList;
		
	}
}
