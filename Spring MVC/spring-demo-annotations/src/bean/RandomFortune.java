package bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService{
	private Random rd = new Random();
	
	private List<String> getRandomFortune() {
		File file = new File("fortune-data.txt");
		List<String> listFortune = new ArrayList<>();
		try {
			listFortune =  Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listFortune; 
	}
	
	@Override
	public String getFortune() {
		return getRandomFortune().get(rd.nextInt(getRandomFortune().size()));
	}
}
