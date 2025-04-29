package com.mobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumTest {
	@Test
	public void intialiseApp() throws MalformedURLException, URISyntaxException {

		// start appium server automatically
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options opt = new UiAutomator2Options();
		opt.setDeviceName("Pixel 9");
		opt.setApp(
				"/Users/codeclouds-yogesh/Documents/MyEclipseWorkspace/mobile_automation/src/test/resources/testing _app/ApiDemos-debug.apk");
		
		AndroidDriver androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), opt);

		// actual automation

		androidDriver.quit();
		service.stop();
	}

}
