package com.yizhao.integration.java;


public class FactoryOfAssertionChecker {
	public BehaviorOfAssertionChecker createChecker(StatesOfClient state) {
		BehaviorOfAssertionChecker f = null;
		if (state.toString().indexOf("UPLOAD") >= 0) {
			f = new AssertionCheckerOfUpload();
		} else if (state.toString().indexOf("DOWNLOAD") >= 0) {
			f = new AssertionCheckerOfDownload();
		}
		return f;
	}
}
