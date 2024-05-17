package com.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.entity.TaskManagerEntity;

public interface TaskManagerRepository extends JpaRepository<TaskManagerEntity, Integer>{
	
	 public List<TaskManagerEntity> findByPriority(String priority);
}
