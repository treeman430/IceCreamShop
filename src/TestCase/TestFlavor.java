package TestCase;

import iceCream.*;
import junit.framework.TestCase;

public class TestFlavor extends TestCase {
	IceCream icecream = new Flavor();
	String expectedDesc;
	double expectedPrice;
	
	public void testFla() {
		
		expectedDesc = "Chocolate";
		expectedPrice = 20.0;
		icecream.setInfo("Chocolate", 20.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
		
		expectedDesc = "Vanilla";
		expectedPrice = 20.0;
		icecream.setInfo("Vanilla", 20.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
	}
}
