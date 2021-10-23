package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bean.BadmintonCoach;
import config.SportConfig;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		BadmintonCoach coach = context.getBean("badmintonCoach", BadmintonCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getAge());
		
		System.out.println(coach.getEmail());
		
		context.close();
	}
}
