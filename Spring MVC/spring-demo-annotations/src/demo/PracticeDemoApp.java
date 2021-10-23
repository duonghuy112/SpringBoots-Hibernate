package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.SwimCoach;

public class PracticeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(swimCoach.getAge());
		System.out.println(swimCoach.getEmail());
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());
		
		context.close();
	}
}
