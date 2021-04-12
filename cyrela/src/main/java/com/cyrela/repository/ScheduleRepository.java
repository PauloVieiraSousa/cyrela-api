package com.cyrela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyrela.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
