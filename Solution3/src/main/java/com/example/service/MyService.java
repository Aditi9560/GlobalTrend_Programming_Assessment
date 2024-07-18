package com.example.service;

import org.springframework.stereotype.Service;

import com.example.logexecutiontime.LogExecutionTime;
	@Service
	public class MyService {
	    @LogExecutionTime
	    public void performTask() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}



