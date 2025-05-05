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
	private static final By DETECT_MY_LOCATION_BTN_LOCATOR = AppiumBy.id("com.bt.bms:id/btn_negative");
	private static final By SELECT_CITY_LOCATOR = AppiumBy.xpath("//android.widget.TextView[@text='Pune']");
	private static final By ALLOW_NOTIFICATION_BUTTON_LOCATOR = AppiumBy
			.xpath("//android.widget.Button[@text='Allow']");
	private static final By HOME_PAGE_HEADER_LOCATOR = AppiumBy
			.id("com.bt.bms:id/title_header_main");
	

	public String verifyUserIsOnHomePage() {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		clickOnGesture(SKIP_BUTTON_LOCATOR);
		clickOnGesture(DETECT_MY_LOCATION_BTN_LOCATOR);
		clickOnGesture(SELECT_CITY_LOCATOR);
		clickOnGesture(ALLOW_NOTIFICATION_BUTTON_LOCATOR);
		return getElementText(HOME_PAGE_HEADER_LOCATOR);
	}

}
