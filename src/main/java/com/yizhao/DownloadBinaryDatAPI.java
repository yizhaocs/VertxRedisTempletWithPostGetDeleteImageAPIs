package com.yizhao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

import redis.clients.jedis.Jedis;

public class DownloadBinaryDatAPI extends PingVerticle {

	public DownloadBinaryDatAPI() {

	}

	public byte[] download() {
		// Connecting to Redis on localhost
		Jedis jedis = new Jedis("localhost");
		byte[] key = { 'k' };
		System.out.println(Arrays.toString(key));
		container.logger().info(Arrays.toString(key));
		return jedis.get(key);
	}
}
