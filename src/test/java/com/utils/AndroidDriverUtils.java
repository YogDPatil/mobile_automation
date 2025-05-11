package com.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
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

	public WebElement findWebElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

	public void longClickGesture(By locator) {
		((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",
						((RemoteWebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).getId(),
						"duration", 2000));
	}

	public String getElementText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public void scrollUptoBottomOfPage() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down",
							"percent", 3.0));
		} while (canScrollMore);
	}

	public void swipeGesture(By locator, String swipeDirection) {
		((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId",
						((RemoteWebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).getId(),
						"direction", swipeDirection, "percent", 0.75));
	}

	public void scrollUptoTheElement(String elementText) {
		androidDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
	}

	public void dragAndDropElement(By locator, int xCordinate, int yCordinate) {
		((JavascriptExecutor) androidDriver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId",
						((RemoteWebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator))).getId(),
						"endX", xCordinate, "endY", yCordinate));
	}

	public void rotateScreen() {
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		androidDriver.rotate(landscape);
	}

}
