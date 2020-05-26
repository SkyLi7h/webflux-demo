package com.example.webfluxdemo.web;

import com.example.webfluxdemo.model.Tweet;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientApp {
    private WebClient client = WebClient.create("http://localhost:8080");

    public void displayTweetById(String id) {
        Mono<Tweet> tweetMono = client.get()
                .uri("/tweets/{id}", id)
                .retrieve()
                .bodyToMono(Tweet.class);

        tweetMono.subscribe(tweet -> System.out.println(tweet.getText()));
    }

    public void displayAllTweets() {
        Flux<Tweet> tweetflux = client.get()
                .uri("/tweets")
                .retrieve()
                .bodyToFlux(Tweet.class);

        tweetflux.subscribe(tweet -> System.out.println(tweet.getText()));
    }

}
