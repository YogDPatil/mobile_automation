package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.MiscelliniousActivity;

public final class MiscelliniousActivityTest extends TestBase {

	@Test
	public void validateRotateScreen() {
		(new MiscelliniousActivity(androidDriver)).rotateScreenToLandscapeMode();
	}

}
