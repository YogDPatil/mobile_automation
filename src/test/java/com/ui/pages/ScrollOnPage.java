package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class ScrollOnPage extends AndroidDriverUtils {

	public ScrollOnPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	private static final By VIEWS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Views");

	public void scrollUptoTheBottomOnPage() {
		clickOnGesture(VIEWS_ELEMENT_LOCATOR);
		scrollUptoBottomOfPage();
	}

}
