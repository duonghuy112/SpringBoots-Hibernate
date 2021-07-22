package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
	
	@Autowired
	@Qualifier("randomFortune")
	private FortuneService fortuneService;
	
	@Value("${age}")
	private int age;
	
	@Value("${email}")
	private String email;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
