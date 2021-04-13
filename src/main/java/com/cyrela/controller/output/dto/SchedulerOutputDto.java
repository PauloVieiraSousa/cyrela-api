package com.cyrela.controller.output.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.cyrela.model.Schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerOutputDto {

	private Instant dateInitial;
	
	private Instant dateFinal;
	
	public SchedulerOutputDto(Schedule schedule){
		this(schedule.getDateInitial(), schedule.getDateFinal());
	}
	
}
