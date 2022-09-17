package ar.edu.unlu.poo.todoapp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

enum status_options {
	DUE, OVERDUE, COMPLETED;
}

enum priorities {
	NO_PRIORITY, LOW_PRIORITY, MEDIUM_PRIORITY, HIGH_PRIORITY;
}

public class Task {
	private String taskTitle;
	private String taskDescription;
	private Boolean completed;
	private status_options status;
	private LocalDateTime dueDate;
	private priorities priority;
	private ArrayList<User> collaborators;
	private LocalDateTime reminderDate; //add TIME
	
	public Task(String taskTitle, String taskDescription, Boolean completed,
			status_options status, LocalDateTime dueDate, priorities priority, 
			ArrayList<User> collaborators, LocalDateTime reminderDate) {
		//constructor
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.completed = completed;
		this.status = status;
		this.dueDate = dueDate;
		this.priority = priority;
		this.collaborators = collaborators;
		this.reminderDate = reminderDate;
	}
	//getters
	public String getTitle() {
		return this.taskTitle;
	}
	public Boolean getCompletedStatus() {
		return this.completed;
	}
	public String getTaskDescription() {
		return this.taskDescription;
	}
	public LocalDateTime getDueDate() {
		return this.dueDate;
	}
	public status_options getStatus() {
		return this.status;
	}
	public priorities getPriority() {
		return this.priority;
	}
	//setters
	public void setTitle(String newTitle) {
		this.taskTitle = newTitle;
	}
	public void setDescription(String newDescription) {
		this.taskDescription = newDescription;
	}
	public void setPriority(priorities newPriority) {
		this.priority = newPriority;
	}
	public void setCompleted() {
		this.completed = true;
	}
	//methods
	public void calculatePriority() {
		LocalDateTime todayDate = LocalDateTime.now();
	    LocalDateTime dueDate = this.dueDate;

	    Duration duration = Duration.between(dueDate, todayDate);
	    long diff = Math.abs(duration.toMinutes()); //1440 MINUTES =  24 HS

		if ((diff) <= 1440) {
			this.priority = priorities.HIGH_PRIORITY;
		}
	}
}
