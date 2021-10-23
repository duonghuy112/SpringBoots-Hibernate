package bean;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		return "Happy fortune";
	}
}
