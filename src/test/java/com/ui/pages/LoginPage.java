package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class LoginPage extends AndroidDriverUtils {
	private AndroidDriver androidDriver;

	public LoginPage(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
	}

	private static final By SKIP_BUTTON_LOCATOR = AppiumBy.id("com.bt.bms:id/launcher_tv_for_skip");
	private static final By DETECT_MY_LOCATION_BTN_LOCATOR = AppiumBy.id("com.bt.bms:id/btn_positive");
	private static final By ACCESS_DEVICE_LOCATION_BUTTON_LOCATOR = AppiumBy
			.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");

	public void goToHomePage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickOnGesture(SKIP_BUTTON_LOCATOR);
		clickOnGesture(DETECT_MY_LOCATION_BTN_LOCATOR);
		clickOnGesture(ACCESS_DEVICE_LOCATION_BUTTON_LOCATOR);

	}

}
