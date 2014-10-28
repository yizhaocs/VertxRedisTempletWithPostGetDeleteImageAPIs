package com.yizhao;

import java.io.IOException;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

public class MainVerticle extends Verticle {
	UploadBinaryDataAPI mUploadBinaryDataAPI;
	DownloadBinaryDatAPI mDownloadBinaryDatAPI;

	public void start() {

		RouteMatcher httpRouteMatcher = new RouteMatcher();
		httpRouteMatcher.post("/redis", new Handler<HttpServerRequest>() {
			@Override
			public void handle(final HttpServerRequest request) {
				mUploadBinaryDataAPI = new UploadBinaryDataAPI();
				try {
					mUploadBinaryDataAPI.upload();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		httpRouteMatcher.get("/redis", new Handler<HttpServerRequest>() {
			@Override
			public void handle(final HttpServerRequest request) {
				mDownloadBinaryDatAPI = new DownloadBinaryDatAPI();
				mDownloadBinaryDatAPI.download();
			}
		});
	}
}
