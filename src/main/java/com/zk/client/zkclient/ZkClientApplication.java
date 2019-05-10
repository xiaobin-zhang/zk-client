package com.zk.client.zkclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZkClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkClientApplication.class, args);
	}
	
}
