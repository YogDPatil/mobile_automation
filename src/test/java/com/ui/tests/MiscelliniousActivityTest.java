package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.MiscelliniousActivity;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public final class MiscelliniousActivityTest extends TestBase {

	@Test
	public void validateRotateScreen() {
		(new MiscelliniousActivity(androidDriver)).rotateScreenToLandscapeMode();
	}

}
