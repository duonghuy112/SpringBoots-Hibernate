package bean;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Track";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void initMethod() {
		System.out.println("Init method");
	}
	
	public void PreDestroyMethod() {
		System.out.println("Pre destroy method");
	}
}
