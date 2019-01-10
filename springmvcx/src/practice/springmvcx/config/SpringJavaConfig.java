package practice.springmvcx.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// we use all java config here no spring xml needed

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"practice.springmvcx"})
// get jdbc properties file
@PropertySource("classpath:jdbc.properties")
public class SpringJavaConfig {

	// representing the environment in which the current application is running. Models two key aspects of the application environment: profiles and properties.
	@Autowired 
	Environment env;
	
	// configure view resolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name="dataSource")
	public DataSource securityDataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		try {
			ds.setDriverClass(env.getProperty("jdbc.driverClassName"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setUser(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		
		ds.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		ds.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		ds.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		ds.setMaxIdleTime(Integer.valueOf(env.getProperty("connection.pool.maxIdleTime")));
		
		return ds;
	}

}
