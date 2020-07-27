package com.dreamsecurity.shopface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
@MapperScan("com.dreamsecurity.shopface")
public class ShopfaceRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopfaceRestApplication.class, args);
	}
}
