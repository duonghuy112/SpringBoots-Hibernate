package practice;

import bean.Coach;
import bean.FortuneService;

public class FootballCoach implements Coach{
	private FortuneService fortuneService;
	
	private int age;
	private String email;
	
	public FootballCoach(FortuneService fortuneService) {
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
		return "Football";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
