package com.yizhao.integration.java;

public class FactoryOfCurlCommandsSetter {
	public BehaviorOfCurlCommandsSetter createSetter(StatesOfClient state) {
		BehaviorOfCurlCommandsSetter ccs = null;
		if (state.toString().indexOf("UPLOAD") >= 0) {
			ccs = new CurlCommandsSetterOfUpload();
		} else if (state.toString().indexOf("DOWNLOAD") >= 0) {
			ccs = new CurlCommandsSetterOfDownload();
		}
		return ccs;
	}
}
