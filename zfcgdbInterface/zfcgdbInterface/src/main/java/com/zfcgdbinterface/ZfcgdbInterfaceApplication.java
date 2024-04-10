package com.zfcgdbinterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan({"com.zfcgdbinterface.dao"})
@EnableAsync
public class ZfcgdbInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZfcgdbInterfaceApplication.class, args);
	}

}
