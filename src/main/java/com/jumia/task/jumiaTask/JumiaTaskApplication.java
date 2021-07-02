package com.jumia.task.jumiaTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class JumiaTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(JumiaTaskApplication.class, args);
	}

	@Autowired
	Environment env;

}
