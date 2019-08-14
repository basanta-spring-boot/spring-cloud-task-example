package com.javatechie.spring.cloud.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

@SpringBootApplication
@EnableTask
public class TestingCloudDbApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to " + args[0] + " community...");

	}

	public static void main(String[] args) {
		System.out.println("Hello-world");
		SpringApplication.run(TestingCloudDbApplication.class, args);
	}

	@BeforeTask
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
				+ taskExecution.getExecutionId() + " started...");

	}

	@AfterTask
	public void onTaskEnd(TaskExecution taskExecution) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
				+ taskExecution.getExecutionId() + " Ended...");

	}

	@FailedTask
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("TaskName : " + taskExecution.getTaskName() + " Execution Id : "
				+ taskExecution.getExecutionId() + " Failed...");

	}

}
