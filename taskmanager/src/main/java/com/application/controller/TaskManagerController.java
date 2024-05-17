package com.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.TaskManagerEntity;
import com.application.taskmanagerservice.TaskManagerService;

@RestController
@RequestMapping("/api")
public class TaskManagerController {
	
	private TaskManagerService taskManagerService;
	
	public TaskManagerController(TaskManagerService theTaskManagerService) {
		taskManagerService = theTaskManagerService;
	}
	
	
	@GetMapping("/task")
	public List<TaskManagerEntity> findAll(){
		return taskManagerService.findAll();
	}
	
	
	@PostMapping("/task")
	public TaskManagerEntity save(@RequestBody TaskManagerEntity theTaskManagerEntity){
		TaskManagerEntity taskManagerEntity = taskManagerService.save(theTaskManagerEntity);
		return taskManagerEntity;
		
	}
	
	@GetMapping("/task/{taskId}")
	public TaskManagerEntity findById(@PathVariable int taskId) {
		TaskManagerEntity taskManagerEntity = taskManagerService.findById(taskId);
		if(taskManagerEntity == null) {
			throw new RuntimeException("the task Id not found: "+taskId);
		}
		return taskManagerEntity;
	}
	
	@PutMapping("/task/{id}")
	public TaskManagerEntity updateTask(@RequestBody TaskManagerEntity taskManagerEntity, @PathVariable int id) {
		taskManagerEntity.setId(id);
		TaskManagerEntity theTaskManagerEntity = taskManagerService.save(taskManagerEntity);
		return theTaskManagerEntity;
	}
	
	@DeleteMapping("/task/{taskId}")
	public String deleteById(@PathVariable int taskId) {
		TaskManagerEntity taskManagerEntity = taskManagerService.findById(taskId);
		if(taskManagerEntity == null) {
			throw new RuntimeException("the task Id not found: "+taskId);
		}
		taskManagerService.deleteById(taskId);
		return "the task Id: "+taskId+" deleted successfully";
	}
	
	@GetMapping("/task/priority/{priority}")
	public List<TaskManagerEntity> getByPriority(@PathVariable String priority){
		return taskManagerService.getPriority(priority);
	}
	
	
	
	
	
	

}
