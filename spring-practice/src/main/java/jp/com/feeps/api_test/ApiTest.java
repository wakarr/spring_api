package jp.com.feeps.api_test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		return "API test OKey by Machong";
	}


}
