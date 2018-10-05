package com.fangshuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fangshuo.lib4fangshuo.plugin.AppPluginBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application extends AppPluginBean {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
