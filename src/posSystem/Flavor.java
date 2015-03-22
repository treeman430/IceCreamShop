package posSystem;

public class Flavor extends IceCream {
	private String flavorDesc = "";
	private double flavorPrice = 0.0;
	
	public void setInfo(String desc, double price) {
		this.flavorDesc = desc;
		this.flavorPrice = price;
	}
	
	public String getDescription() {
		return this.flavorDesc;
	}
	
	public double getPrice() {
		return this.flavorPrice;
	}

}
