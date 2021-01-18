package com.raj.boot.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job started");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job ended " + jobExecution.getStatus().toString());
	}

}
