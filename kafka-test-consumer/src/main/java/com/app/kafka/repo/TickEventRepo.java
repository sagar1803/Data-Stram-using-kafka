package com.app.kafka.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kafka.entity.FinalResult;
import com.app.kafka.entity.TickEvent;


public interface TickEventRepo extends JpaRepository<FinalResult, Integer> {

}
