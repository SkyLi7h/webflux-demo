package com.example.webfluxdemo;

import com.example.webfluxdemo.web.WebClientApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebfluxDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebfluxDemoApplication.class, args);

		WebClientApp wca = new WebClientApp();
		wca.displayTweetById("5eaeffe7cdac52416c6b14b7");
		wca.displayAllTweets();
	}

}
