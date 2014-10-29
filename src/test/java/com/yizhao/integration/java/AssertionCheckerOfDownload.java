package com.yizhao.integration.java;

public class AssertionCheckerOfDownload implements BehaviorOfAssertionChecker {

	@Override
	public void execute(StatesOfClient state) {
		switch (state) {
		case STATE_DOWNLOAD:
			break;
		default:
		}
	}

}
