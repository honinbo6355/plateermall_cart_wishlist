package com.plateer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ShoppingmallCartWishlistBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingmallCartWishlistBootApplication.class, args);
        log.error("hello");
    }
}
