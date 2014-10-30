package com.yizhao;

import java.util.Arrays;

import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpServerFileUpload;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.json.JsonObject;

import redis.clients.jedis.Jedis;

public class ApiOfPost extends SuperClassOfApis {
	public ApiOfPost() {

	}

	public void post(final Vertx vertx, final HttpServerRequest bridge_between_server_and_client){
		try {
			bridge_between_server_and_client.expectMultiPart(true);
			bridge_between_server_and_client.uploadHandler(new Handler<HttpServerFileUpload>() {
				public void handle(final HttpServerFileUpload upload) {
					final Buffer mainBuffer = new Buffer();
					upload.dataHandler(new Handler<Buffer>() {
						@Override
						public void handle(Buffer buffer) {
							mainBuffer.appendBuffer(buffer);
						}
					}).endHandler(new Handler<Void>() {
						@Override
						public void handle(Void arg0) {
							JsonObject response = new JsonObject();
							if ("OK".equals(radis(bridge_between_server_and_client, mainBuffer))) {
								response.putString("status", "0");
								response.putString("statusDescription", "Success");
								bridge_between_server_and_client.response().end(response.encodePrettily());
							} else {
								response.putString("status", "0");
								response.putString("statusDescription", "Store to Redis failed");
								bridge_between_server_and_client.response().end(response.encodePrettily());
							}
						}
					});

				}
			});
		} catch (Exception e) {
			container.logger().error(e.getStackTrace());
			JsonObject response = new JsonObject();
			response.putString("status", "1");
			response.putString("statusDescription", "Unknown Error");
			bridge_between_server_and_client.response().end(response.encodePrettily());
		} finally {
			
		}
	}

	public String radis(HttpServerRequest bridge_between_server_and_client, Buffer mainBuffer) {
		// Connecting to Redis on localhost
		Jedis jedis = new Jedis("localhost");
		byte[] value = mainBuffer.getBytes();
		return jedis.set(bridge_between_server_and_client.params().get("key").getBytes(), value);
	}
}
