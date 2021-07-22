package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VolleyballCoach implements Coach{
	
	@Autowired
	@Qualifier("sadFortune")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Volleyball";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
