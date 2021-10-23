package practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		FootballCoach footballCoach = context.getBean("football", FootballCoach.class);
		
		System.out.println(footballCoach.getDailyWorkout());
		
		System.out.println(footballCoach.getDailyFortune());
		
		System.out.println(footballCoach.getAge());
		
		System.out.println(footballCoach.getEmail());
		
		context.close();
	}
}
