package practice.springmvcx.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

//@Component("employee")
//@Scope("prototype")
public class Employee {
	
	String firstName;
	String lastName;
	String fatherName;
	String country="IN";
	String sex;
	String[] languages; //check box use array
	
	
	private Map<String, String> countries;

	private Map<String, String> allLanguages;
	
	public Employee() {
		System.out.println("Creating Employee obj");
		// instead of having the static country field in html we can create a hash map and show that in the view
		countries = new HashMap<>();
		countries.put("IN", "India");
		countries.put("FR", "France");
		countries.put("BR", "Brazil");
		countries.put("DE", "Germany");
		countries.put("US", "United States");
		countries.put("EU", "Europe");
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public String getFirstName() {
		System.out.println("Getting First Name  "+ firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Setting first Name - "+ firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Map<String, String> getAllLanguages() {
		return allLanguages;
	}
	
	@Value("${languages}")  //load from properties file
	public void setAllLanguages(Map<String, String> allLanguages) {
		this.allLanguages = allLanguages;
	}


}
