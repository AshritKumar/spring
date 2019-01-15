package practice.springRest.restc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController // specify that this is a rest controller
public class DemoRestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hahahahaha";
	}

}
