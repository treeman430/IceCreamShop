package TestCase;

import iceCream.*;
import junit.framework.TestCase;

public class TestDecorator extends TestCase {
		
	public void testDec() {
		
		
		String expectedDesc;
		double expectedPrice;
		
		expectedDesc = "Chocolate, M&M";
		expectedPrice = 25.0;
		IceCream icecream = new Flavor();
		icecream.setInfo("Chocolate", 20.0);
		icecream = new Decorator(icecream);
		icecream.setInfo("M&M", 5.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
		
		expectedDesc = "Chocolate, Strawberry";
		expectedPrice = 24.0;
		icecream = new Flavor();
		icecream.setInfo("Chocolate", 20.0);
		icecream = new Decorator(icecream);
		icecream.setInfo("Strawberry", 4.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
		
		expectedDesc = "Vanilla, M&M";
		expectedPrice = 25.0;
		icecream = new Flavor();
		icecream.setInfo("Vanilla", 20.0);
		icecream = new Decorator(icecream);
		icecream.setInfo("M&M", 5.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
		
		expectedDesc = "Vanilla, Strawberry";
		expectedPrice = 24.0;
		icecream = new Flavor();
		icecream.setInfo("Vanilla", 20.0);
		icecream = new Decorator(icecream);
		icecream.setInfo("Strawberry", 4.0);
		assertEquals(expectedDesc, icecream.getDescription());
		assertEquals(expectedPrice, icecream.getPrice());
	}
}
