package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import bean.BadmintonCoach;
import bean.Coach;
import bean.FortuneService;
import bean.HappyFortune;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {
	@Bean
	public FortuneService happyFortune() {
		return new HappyFortune();
	}
	
	@Bean
	public Coach badmintonCoach() {
		return new BadmintonCoach(happyFortune());
	}
}
