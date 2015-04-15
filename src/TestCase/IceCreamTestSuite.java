package TestCase;

import junit.framework.Test;
import junit.framework.TestSuite;

public class IceCreamTestSuite extends TestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Ice Cream Test");

		suite.addTestSuite(TestFlavor.class);
		suite.addTestSuite(TestDecorator.class);

		return suite;
	}
}

