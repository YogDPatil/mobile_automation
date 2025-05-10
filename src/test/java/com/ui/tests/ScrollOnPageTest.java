package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.ScrollOnPage;

public final class ScrollOnPageTest extends TestBase {

	@Test
	public void verifyScrollOnUpToTheEndOfPage() {
		(new ScrollOnPage(androidDriver)).scrollUptoTheBottomOnPage();
	}

}
