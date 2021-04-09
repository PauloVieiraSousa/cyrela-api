package com.cyrela.controller.output.dto;

import com.cyrela.model.Schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulerOutputDto {

	private String name;
	
	/*
	SchedulerOutputDto(Schedule schedule){
		this.name = schedule.getName();
	}
	
	public static SchedulerOutputDto build(Schedule schedule) {
		return new SchedulerOutputDto(schedule);
	}
	
	*/
}
