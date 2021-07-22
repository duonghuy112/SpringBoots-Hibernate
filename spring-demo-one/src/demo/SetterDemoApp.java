package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.CricketCoach;

public class SetterDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CricketCoach cricketCoach = context.getBean("cricket", CricketCoach.class);

		System.out.println(cricketCoach.getDailyWorkout());

		System.out.println(cricketCoach.getDailyFortune());
		
		System.out.println(cricketCoach.getAge());
		
		System.out.println(cricketCoach.getEmail());

		context.close();
	}
}
