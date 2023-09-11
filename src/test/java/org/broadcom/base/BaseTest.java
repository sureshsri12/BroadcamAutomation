package org.broadcom.base;

import java.lang.reflect.Method;
import java.net.URL;

import org.broadcom.constants.FrameworkConstants;
import org.broadcom.driver.WinDriver;
import org.broadcom.utils.zerocell.ExcelReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;

import io.appium.java_client.windows.WindowsDriver;

public class BaseTest {

	public static WindowsDriver dtdriver = null;

	public void setUp() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", FrameworkConstants.getAppPath());
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "Windows10Machine");
		WinDriver.start();

		dtdriver = new WindowsDriver(new URL(FrameworkConstants.getUrl()), cap);

	}

	public void killDesktop() throws Exception {
		Actions actions = new Actions(dtdriver);
		String killDesktop = Keys.chord(Keys.ALT, Keys.F4);
		actions.sendKeys(killDesktop);
		actions.perform();
	}
	
	@DataProvider
	public static Object[] getData(Method method) {
		return ExcelReader.getTestdatas().stream().filter(e -> e.getTestCase().equalsIgnoreCase(method.getName()))
				.toArray();

	}
		
}
