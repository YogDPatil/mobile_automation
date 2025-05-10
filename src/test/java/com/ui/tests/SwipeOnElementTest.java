package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.SwipeElement;

public final class SwipeOnElementTest extends TestBase{
	
	@Test
	public void verifySwipingOnElement() {
		(new SwipeElement(androidDriver)).validateSwipeOnImages();
	}

}
