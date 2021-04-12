package com.cyrela.controller;



import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cyrela.controller.input.dto.ScheduleInputDto;
import com.cyrela.controller.output.dto.ClienteOutputDto;
import com.cyrela.controller.output.dto.ResponseOutput;
import com.cyrela.controller.output.dto.SchedulerOutputDto;
import com.cyrela.model.Cliente;
import com.cyrela.model.Schedule;
import com.cyrela.repository.ClienteRepository;
import com.cyrela.repository.ScheduleRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;


@Api(value = "Agenda")
@AllArgsConstructor
@RequestMapping("api")
@RestController()
public class ScheduleController {
	
	ScheduleRepository scheduleRepository;
	ClienteRepository clienteRespoitory;
	
	
	@ApiOperation(value = "Adiciona uma nova agenda")
	@PostMapping(path = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity dateSchedule(@RequestBody ScheduleInputDto scheduleInputDto, UriComponentsBuilder uriBuilder){
		Cliente cliente = clienteRespoitory.getOne(scheduleInputDto.getClienteId());
		Schedule schedule = new Schedule(scheduleInputDto.getSubject(), scheduleInputDto.getDateInitial(), scheduleInputDto.getDateFinal(),cliente);
		Schedule save = scheduleRepository.save(schedule);
		URI path = uriBuilder.path("/schedule/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(path).body(new ResponseOutput("Agendado com sucesso"));
	}

	@ApiOperation(value = "Retorna as agendas geradas")
	@GetMapping(path = "/dates-scheduled", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SchedulerOutputDto>> datesSchedules(){
		List<Schedule> list = scheduleRepository.findAll();
		return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(list.stream().map(SchedulerOutputDto::new).collect(Collectors.toList()));
	}
	
	
}
