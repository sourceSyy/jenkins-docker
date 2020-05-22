package com.deploy.jenkinsdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsDockerApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "hello Deploy with jenkins and docker";
	}

	@GetMapping("/hello")
	public String hello(String name){
		return "hello" + name;
	}

}
