package com.yizhao.integration.java;

public class CurlCommandsSetterOfUpload extends BehaviorOfCurlCommandsSetter {

	@Override
	public void execute(StatesOfClient state) {
		switch (state) {
		case STATE_UPLOAD:
			break;
		default:
			pmfc.printCurrentStateInfo();
		}
	}
}
