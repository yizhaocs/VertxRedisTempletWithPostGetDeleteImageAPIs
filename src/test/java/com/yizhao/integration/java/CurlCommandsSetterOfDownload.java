package com.yizhao.integration.java;



public class CurlCommandsSetterOfDownload extends BehaviorOfCurlCommandsSetter{

	@Override
	public void execute(StatesOfClient state) {
		switch (state) {
		case STATE_DOWNLOAD:
			break;
		default:
			pmfc.printCurrentStateInfo();
		}
	}

}
