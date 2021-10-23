package bean;

import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach, DisposableBean{
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Base ball";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void initMethod() {
		System.out.println("Init method");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Basebal destroy method");
	}
}
