package ru.iflexible.talent_management.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.iflexible.talent_management")
@EnableJpaRepositories(basePackages = {"ru.iflexible.talent_management"})
@EntityScan("ru.iflexible.talent_management.storage.entity")
public class TalentManagementApplication {
    public static void main(String[] args)  {
        SpringApplication.run(ru.iflexible.talent_management.application.TalentManagementApplication.class, args);
    }
}