package com.ui.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class LongClickOnELement extends AndroidDriverUtils {
	private AndroidDriver androidDriver;

	public LongClickOnELement(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
	}

	private static final By VIEWS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Views");
	private static final By EXPANDABLE_LIST_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Expandable Lists");
	private static final By CUSTOM_ADAPTER_ELEMENT_LOCATOR = AppiumBy
			.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]");
	private static final By PEOPLE_NAMES_ELEMENT_LOCATOR = AppiumBy
			.xpath("//android.widget.TextView[@text='People Names']");
	private static final By PEOPLE_NAMES_MENU_LIST_LOCATOR = AppiumBy.id("android.widget.TextView");

	public List<String> verifyMenuListByLongClickingOnElement() {
		clickOnGesture(VIEWS_ELEMENT_LOCATOR);
		clickOnGesture(EXPANDABLE_LIST_ELEMENT_LOCATOR);
		clickOnGesture(CUSTOM_ADAPTER_ELEMENT_LOCATOR);
		longClickGesture(PEOPLE_NAMES_ELEMENT_LOCATOR);
//		findListOfWebELements(PEOPLE_NAMES_MENU_LIST_LOCATOR);
		List<String> ppl_name_list = new ArrayList<>();
		for (WebElement ele : findListOfWebELements(PEOPLE_NAMES_MENU_LIST_LOCATOR)) {
			ppl_name_list.add(ele.getText());
		}
		return ppl_name_list;
	}

}
