package posSystem;

public class Decorator extends IceCreamDecorators {
	private String decoratorSep = ", ";
	private String decoratorDesc = "";
	private double decoratorPrice = 0.0;
	
	public Decorator (IceCream iceCream) {
		super(iceCream);
	}
	
	public void setInfo(String desc, double price) {
		this.decoratorDesc = desc;
		this.decoratorPrice = price;
	}
	
	public String getDescription() {
		String baseDesc = iceCream.getDescription();
		return baseDesc + decoratorSep + this.decoratorDesc;
	}
	
	public double getPrice() {
		double basePrice = iceCream.getPrice();
		return basePrice + this.decoratorPrice;
	}
}
