package com.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public abstract class AndroidDriverUtils {
	private WebDriverWait wait;
	private AndroidDriver androidDriver;

	public AndroidDriverUtils(AndroidDriver androidDriver) {
		wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
		this.androidDriver = androidDriver;
	}

	public void clickOn(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public List<WebElement> findListOfWebELements(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public WebElement findWebElement(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void clickOnByJSE(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) androidDriver;
		js.executeScript("arguments[0].click()", wait.until(ExpectedConditions.elementToBeClickable(ele)));
	}

	public void clickOnGesture(WebElement element) {
		androidDriver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) wait.until(ExpectedConditions.visibilityOf(element))).getId()));

	}

	public void clickOnGesture(By locator) {
		androidDriver.executeScript("mobile: clickGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).getId()));

	}

}
