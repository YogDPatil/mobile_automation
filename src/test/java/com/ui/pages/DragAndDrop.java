package com.ui.pages;

import org.openqa.selenium.By;

import com.utils.AndroidDriverUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public final class DragAndDrop extends AndroidDriverUtils {

	private static final By VIEWS_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Views");
	private static final By DRAG_AND_DROP_TAB_ELEMENT_LOCATOR = AppiumBy.accessibilityId("Drag and Drop");
	private static final By DRAG_ELEMENT_LOCATOR = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
	private static final By DROPPED_TEXT_LOCATOR = AppiumBy.xpath("//android.widget.TextView[@text='Dropped!']");

	public DragAndDrop(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	public void verifyDragAndDropElement() {
		clickOnGesture(VIEWS_ELEMENT_LOCATOR);
		clickOnGesture(DRAG_AND_DROP_TAB_ELEMENT_LOCATOR);
		dragAndDropElement(DRAG_ELEMENT_LOCATOR, 629, 654);
		findWebElement(DROPPED_TEXT_LOCATOR).isDisplayed();
	}

}
