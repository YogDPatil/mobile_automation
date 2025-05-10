package com.ui.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class SwipeElement extends AndroidDriverUtils {

	private static final By VIEWS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Views");
	private static final By GALLARY_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Gallery");
	private static final By PHOTOS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("1. Photos");

	private static final By FIRST_PHOTO_ELEMENT_LOCATOR = AppiumBy.xpath("(//android.widget.ImageView)[1]");

	public SwipeElement(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	public void validateSwipeOnImages() {
		clickOnGesture(VIEWS_ELEMENT_LOCATOR);
		clickOnGesture(GALLARY_ELEMENT_LOCATOR);
		clickOnGesture(PHOTOS_ELEMENT_LOCATOR);
		Assert.assertEquals(findWebElement(FIRST_PHOTO_ELEMENT_LOCATOR).getDomAttribute("focusable"), "true");
		swipeGesture(FIRST_PHOTO_ELEMENT_LOCATOR, "left");
		Assert.assertEquals(findWebElement(FIRST_PHOTO_ELEMENT_LOCATOR).getDomAttribute("focusable"), "false");
	}

}
