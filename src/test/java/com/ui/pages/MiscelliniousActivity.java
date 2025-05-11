package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class MiscelliniousActivity extends AndroidDriverUtils {

	private static final By VIEWS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Views");
	private static final By WEBVIEW_ELEMENT_LOCATOR = AppiumBy.accessibilityId("WebView");

	public MiscelliniousActivity(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	public void rotateScreenToLandscapeMode() {
		clickOnGesture(VIEWS_ELEMENT_LOCATOR);
		scrollUptoTheElement("WebView");
		clickOnGesture(WEBVIEW_ELEMENT_LOCATOR);
		rotateScreen();
	}

}
