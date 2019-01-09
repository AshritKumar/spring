package practice.springmvcx.security.controller;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		printUserSecurityContext();
		return "login";
	}
	
	@GetMapping("/noAuth")
	public String noAtuhController() {
		return "accessDenied";
	}

	public void printUserSecurityContext() {
		
		List<String> roles =  SecurityContextHolder.getContext()
							 .getAuthentication()
							 .getAuthorities()
							 	.stream()
							 	.map(a -> a.getAuthority())
							 	.collect(Collectors.toList());
		System.out.println("Printing roles");
		System.out.println(roles);
		
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		Set<?> collect = authorities.stream()
					.map(a -> a.getClass())
					.collect(Collectors.toSet());*/
	
		
	}
}
