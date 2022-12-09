package decoratorPattern;

public class MainTest {

	public static void main(String[] args) {
		
		ICar audi = new Audi(1_000);
		audi.showPrice();
		
		ICar audi3 = new A3(audi, "A3");
		audi3.showPrice();
		
		ICar audi4 = new A4(audi3, "A4");
		audi4.showPrice();
		
	}
	
}

