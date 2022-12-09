package decoratorPattern;

public class Audi implements ICar{

	private int cost;
	
	public Audi(int cost) {
		this.cost = cost;
	}
	
	@Override
	public int getPrice() {
		return this.cost;
	}

	@Override
	public void showPrice() {
		System.out.println("Audi 는  " + cost + " 만 원 입니다.");
	}

}
