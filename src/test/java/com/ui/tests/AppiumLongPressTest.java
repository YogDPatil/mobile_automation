package com.ui.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.LongClickOnELement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public final class AppiumLongPressTest extends TestBase {

	@Test
	public void validateMenuDisplayedAfterLongPressOnElement() {
		LongClickOnELement longClickOnELement = new LongClickOnELement(androidDriver);
		System.out.println(longClickOnELement.verifyMenuListByLongClickingOnElement());
//		Assert.assertEquals(longClickOnELement.verifyMenuListByLongClickingOnElement(), "Welcome Guest!",
//				"User is not on Home Page.");
	}

}
