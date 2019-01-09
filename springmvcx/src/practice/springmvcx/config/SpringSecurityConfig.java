package practice.springmvcx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

// to enable security config
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	// provide custom login form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.anyRequest().authenticated() // All requests are authenticated
			.antMatchers("/").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
			.antMatchers("/adminAction/**").hasRole("ADMIN")
			.antMatchers("/empAction/**").hasRole("EMPLOYEE")
			.antMatchers("/managerAction/**").hasAnyRole("EMPLOYEE", "MANAGER")
			.and()
			.formLogin()
				.loginPage("/login") // we have write controller for this login request
				.loginProcessingUrl("/processLogin") // Don't need to write this controller
				.permitAll() // permit all users for login
				.and()
				.logout().permitAll() // logout support
				.and()
				.exceptionHandling().accessDeniedPage("/noAuth");
				
			
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(userBuilder.username("ASH").password("ash").roles("ADMIN"))
				.withUser(userBuilder.username("SAM").password("sam").roles("EMPLOYEE"))
				.withUser(userBuilder.username("KAM").password("kam").roles("EMPLOYEE","MANAGER"));
		
	}
	 

}
