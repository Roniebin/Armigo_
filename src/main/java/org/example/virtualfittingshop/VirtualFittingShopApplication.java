package org.example.virtualfittingshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VirtualFittingShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualFittingShopApplication.class, args);
    }

}
