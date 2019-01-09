package practice.springmvcx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("smvc") // all the request mapping will have suffix smvc
public class HomeContorller {
	
	 // Default path localhost:8080/springmvcx/smvc
	// controller method and add model and requet objects as parameters, Andy data set into model will be internally set into request obj by spring
	@RequestMapping("/sendData") // will wap to the incoming request address
	public String handelFormRequest(HttpServletRequest request, Model model) {
		String data = (String)request.getParameter("data");
		model.addAttribute("testData",data); // will be set in request attribute
		model.addAttribute("Test","TestVal"); // will be set in request attribute
		return "getData";
	}
	
	@RequestMapping("/sendDataWithAnnotation") // @ReuestParam can be used to get from params from request object
	public String handelFormRequestWithBinding(@RequestParam("data") String formData, Model model) {
		model.addAttribute("annotateData", formData.toUpperCase());
		return "getData";
	}

}
