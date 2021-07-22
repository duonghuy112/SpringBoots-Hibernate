package bean;

import org.springframework.beans.factory.annotation.Value;

public class BadmintonCoach implements Coach{
	
	private FortuneService fortuneService;
	
	@Value("${age}")
	private int age;
	
	@Value("${email}")
	private String email;
	
	public BadmintonCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
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
		return "Bidminton";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
