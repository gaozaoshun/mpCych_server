package com.mtty.igood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mtty.igood.dao")
@SpringBootApplication
public class IgoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgoodApplication.class, args);
	}
}
