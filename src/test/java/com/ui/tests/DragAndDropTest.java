package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.DragAndDrop;

public final class DragAndDropTest extends TestBase {

	@Test
	public void validateDragAndDropElement() {
		(new DragAndDrop(androidDriver)).verifyDragAndDropElement();
	}

}
