package org.perscholas.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringappApplication.class, args);
		System.out.println("We have ran. (From SpringappApplication");
	}

}