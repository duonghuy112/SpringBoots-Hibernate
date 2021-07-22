package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Coach;

public class BeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach coach1 = context.getBean("coach", Coach.class);
		
		Coach coach2 = context.getBean("coach", Coach.class);
		
		System.out.println(coach1 == coach2);
		
		System.out.println(coach1.getDailyWorkout());

		System.out.println(coach1.getDailyFortune());
		
		context.close();
	}
}
