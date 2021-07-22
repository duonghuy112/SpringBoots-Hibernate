package bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameCoach implements Coach{

	@Autowired
	@Qualifier("randomFortune")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Game";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("Init method - " + fortuneService.getFortune());
	}
}
