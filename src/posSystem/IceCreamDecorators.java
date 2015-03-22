package posSystem;

public abstract class IceCreamDecorators extends IceCream {
	IceCream iceCream;
	
	public IceCreamDecorators (IceCream iceCream) {
		this.iceCream = iceCream;
	}
	
	public abstract void setInfo(String desc, double price);
	public abstract String getDescription();
	public abstract double getPrice();
}
