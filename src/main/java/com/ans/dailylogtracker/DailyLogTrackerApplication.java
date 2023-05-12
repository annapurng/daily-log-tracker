package com.ans.dailylogtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ans.dailylogtracker"})
public class DailyLogTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyLogTrackerApplication.class, args);
	}

}
