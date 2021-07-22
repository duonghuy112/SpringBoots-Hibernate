package bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean{
	
	@Autowired
	@Qualifier("happyFortune")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Tennis";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("Init method");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method");
	}
}
