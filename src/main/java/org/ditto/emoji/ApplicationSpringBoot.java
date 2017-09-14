package org.ditto.emoji;

import org.ditto.emoji.grpc.GifGrpcService;
import org.ditto.emoji.grpc.GreeterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationSpringBoot {

    @Bean
    public GreeterService greeterService() {
        return new GreeterService();
    }


    @Bean
    public GifGrpcService emojiService() {
        return new GifGrpcService();
    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpringBoot.class, args);
    }
}
