package com.application.taskmanagerservice;

import java.util.List;

import com.application.entity.TaskManagerEntity;

public interface TaskManagerService {
	
	List<TaskManagerEntity> findAll();
	
	TaskManagerEntity save(TaskManagerEntity theTaskManagerEntity);
	
	TaskManagerEntity findById(int id);
	
	void deleteById(int id);
	
	List<TaskManagerEntity> getPriority(String periority);
	
	
	
	

}
