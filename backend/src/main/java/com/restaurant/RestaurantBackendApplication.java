package com.restaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class RestaurantBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    // 确保 data 目录存在（用于存放 sqlite 文件）
    @Bean
    CommandLineRunner ensureDataDir() {
        return args -> {
            File dataDir = new File("data");
            if (!dataDir.exists()) {
                dataDir.mkdirs();
                System.out.println("created data directory");
            }
        };
    }
}