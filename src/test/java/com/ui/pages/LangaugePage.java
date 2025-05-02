package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class LangaugePage extends AndroidDriverUtils {
	private AndroidDriver androidDriver;

	public LangaugePage(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
	}

	private static final By ALL_LANG_LOCATOR = AppiumBy.className("android.widget.FrameLayout");

	public void selectLangauge() {
		WebElement ele = findListOfWebELements(ALL_LANG_LOCATOR).get(1);
		ele.click();
	}

}
