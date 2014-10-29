package com.yizhao;


public class ConstantsS {
	/* Setup for Singleton pattern */
	private static ConstantsS instance = null;

	private ConstantsS() {

	}

	public static ConstantsS getInstance() {
		if (instance == null) {
			instance = new ConstantsS();
		}
		return instance;
	}
}
