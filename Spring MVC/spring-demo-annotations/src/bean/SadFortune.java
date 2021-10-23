package bean;

import org.springframework.stereotype.Component;

@Component
public class SadFortune implements FortuneService{

	@Override
	public String getFortune() {
		return "Sad fortune";
	}
}
