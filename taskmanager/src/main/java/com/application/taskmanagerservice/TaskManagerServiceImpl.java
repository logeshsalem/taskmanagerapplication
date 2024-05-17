package com.application.taskmanagerservice;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.application.entity.TaskManagerEntity;
import com.application.repository.TaskManagerRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{
	
	private TaskManagerRepository theTaskManagerRepository;
	
	public TaskManagerServiceImpl(TaskManagerRepository taskManagerRepository) {
		theTaskManagerRepository = taskManagerRepository;
	}

	@Override
	public List<TaskManagerEntity> findAll() {
		return theTaskManagerRepository.findAll();
	}

	@Override
	public TaskManagerEntity save(TaskManagerEntity theTaskManagerEntity) {
		return theTaskManagerRepository.save(theTaskManagerEntity);
	}

	@Override
	public TaskManagerEntity findById(int id) {
		Optional<TaskManagerEntity> taskManager = theTaskManagerRepository.findById(id);
		if(taskManager.isPresent()) {
			return taskManager.get();
		}else {
			throw new RuntimeException("the task id not found: "+id);
		}
	}

	@Override
	public void deleteById(int id) {
		theTaskManagerRepository.deleteById(id);		
	}

	@Override
	public List<TaskManagerEntity> getPriority(String periority) {
		return theTaskManagerRepository.findByPriority(periority);
	}
	
	

}
