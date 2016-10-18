package js.testng;

import java.util.List;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

public class TestNgRunner {
	
	public static void main(String[] args) throws Exception {
		final TestNG testNG = new TestNG(true);
		final Parser parser = new Parser("test/js/testng/testng.xml");
		final List<XmlSuite> suites = parser.parseToList();
		testNG.setXmlSuites(suites);
		testNG.run();
	}

}
