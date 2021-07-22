package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.TennisCoach;

public class AnnotationBeanLifeCycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TennisCoach coach1 = context.getBean("tennisCoach", TennisCoach.class);
		TennisCoach coach2 = context.getBean("tennisCoach", TennisCoach.class);
		
		System.out.println(coach1 == coach2);
		
		System.out.println(coach1);
		System.out.println(coach2);
		
		context.close();
	}
}
