package practice;

import java.util.Random;

import bean.FortuneService;

public class RandomFortune implements FortuneService{
	private Random rd = new Random();
	private String[] fortunes = {"happy", "sad", "lucky", "fun", "rain", "shine"};

	@Override
	public String getFortune() {
		return fortunes[rd.nextInt(fortunes.length)];
	}
}
