package com.ui.tests;

import java.io.File; 
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.ui.pages.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class TestBase {

	private AppiumDriverLocalService service;
	protected static AndroidDriver androidDriver;
	protected LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void startAppiumServerAndInitialiseAppiumDriver() throws MalformedURLException, URISyntaxException {
		Map<String, String> env = new HashMap<>(System.getenv());
		String androidHome = env.get("ANDROID_HOME");
		String androidSdkRoot = env.get("ANDROID_SDK_ROOT");
		// Ensure the environment variables are correctly set
		if (androidHome == null || androidSdkRoot == null) {
			throw new IllegalStateException(
					"ANDROID_HOME or ANDROID_SDK_ROOT is not set in the environment variables.");
		}
//		// Set them explicitly (required by Appium process)
		env.put("ANDROID_HOME", androidHome);
		env.put("ANDROID_SDK_ROOT", androidSdkRoot);

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).build();
		service.start();

		UiAutomator2Options opt = new UiAutomator2Options();
		opt.setDeviceName("Pixel 9");
		opt.setApp(
				"/Users/codeclouds-yogesh/Documents/MyEclipseWorkspace/mobile_automation/src/test/resources/testing _app/bookmyshow.apk");

		androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), opt);
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginPage = new LoginPage(androidDriver);
	}

	public AndroidDriver getAndroidDriver() {
		return androidDriver;
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		androidDriver.quit();
		service.stop();
	}
}
