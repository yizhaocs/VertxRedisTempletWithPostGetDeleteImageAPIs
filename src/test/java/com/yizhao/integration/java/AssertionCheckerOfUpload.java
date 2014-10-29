package com.yizhao.integration.java;

public class AssertionCheckerOfUpload implements BehaviorOfAssertionChecker {

	@Override
	public void execute(StatesOfClient state) {
		switch (state) {
		case STATE_UPLOAD:
			break;
		default:
		}
	}

}
