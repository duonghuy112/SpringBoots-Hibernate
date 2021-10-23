package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.BaseballCoach;
import bean.Coach;

public class PrototypeBeanLifeCycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("prototypeBeanLifeCycle-applicationContext.xml");
		
		Coach coach1 = context.getBean("coach", BaseballCoach.class);
		
		Coach coach2 = context.getBean("coach", BaseballCoach.class);
		
		System.out.println(coach1.getDailyWorkout());
		
		System.out.println(coach2.getDailyFortune());
		
		context.close();
	}
}
