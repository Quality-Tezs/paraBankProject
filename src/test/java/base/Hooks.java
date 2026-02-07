package base;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverFactory;

public class Hooks {
	
	@Before
	public void setup(){
		DriverFactory.getDriver();
	}
	
	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
