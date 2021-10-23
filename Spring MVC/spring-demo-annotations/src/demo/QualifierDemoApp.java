package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Coach;

public class QualifierDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("volleyballCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}
}
