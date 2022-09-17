package ar.edu.unlu.poo.todoapp;

import java.util.ArrayList;

public class TaskManager {
	private ArrayList<Task> tasksList;
	private ArrayList<Task> completedTasksList;
	
	public TaskManager(ArrayList<Task> tasksList, ArrayList<Task> completedTasksList) {
		this.tasksList = tasksList;
		this.completedTasksList = completedTasksList;
	}
	//methods
	public ArrayList<Task> returnDueTasks() {
		ArrayList<Task> dueTasks = new ArrayList<Task>();
		
		this.tasksList = sortTasks(this.tasksList);
		
		for (Task task : this.tasksList) {
			if(task.getStatus() == status_options.DUE) {
				dueTasks.add(task);
			}
		}
		return dueTasks;
	}
	public Task searchTaskByTitle(String title) {
		Task foundTask = null; //NEW?
		for (Task task : this.tasksList) {
			if(task.getTitle().equals(title)) {
				foundTask = task;
			}
		}
		return foundTask;
	}
	public void setTaskAsCompleted(Task taskToComplete) {
		taskToComplete.setCompleted();
	}
	public ArrayList<Task> showCompletedTasks() {
		ArrayList<Task> completedTasks = new ArrayList<Task>();
		for (Task task : this.completedTasksList) {
			if(task.getCompletedStatus() == true) {
				completedTasks.add(task);
			}
		}
		return completedTasks;
	}
	
	public ArrayList<Task> sortTasks(ArrayList<Task> tasksToSort) {
		ArrayList<Task> high = new ArrayList<Task>();
		ArrayList<Task> medium = new ArrayList<Task>();
		ArrayList<Task> low = new ArrayList<Task>();
		ArrayList<Task> no = new ArrayList<Task>();
		for (Task task : tasksToSort) {
			if(task.getPriority() == priorities.HIGH_PRIORITY) {
				high.add(task);
			} else if (task.getPriority() == priorities.MEDIUM_PRIORITY) {
				medium.add(task);
			} else if (task.getPriority() == priorities.LOW_PRIORITY) {
				low.add(task);
			} else {
				no.add(task);
			}
		}
		high.addAll(medium);
		high.addAll(low);
		high.addAll(no);
		return high;
	}
	
}
