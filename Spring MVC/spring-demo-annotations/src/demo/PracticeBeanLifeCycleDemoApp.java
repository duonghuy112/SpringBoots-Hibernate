package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Coach;

public class PracticeBeanLifeCycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("gameCoach", Coach.class);
		
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}
}
