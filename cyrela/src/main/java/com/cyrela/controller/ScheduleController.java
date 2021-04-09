package com.cyrela.controller;



import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyrela.controller.output.dto.SchedulerOutputDto;
import com.cyrela.model.Schedule;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("api")
@RestController()
public class ScheduleController {

	@GetMapping(path = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> exampleSchedule() {
		return ResponseEntity.ok("Funcionou");
	}
}
