package com.course.rabbitmqproducer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;

@SpringBootApplication
// @EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {
    
	private Employee emp=null;
	@Autowired
	private HumanResourceProducer humanResourceProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 7; i++) {
			emp = new Employee("emp " + i, "Employee " + i, LocalDate.now());
			humanResourceProducer.sendMessage(emp);
		}
	}

}
