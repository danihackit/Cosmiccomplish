import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Task {
	private int rewardValue;
	private String taskName;
	private String dueDate;
	private int positionInQueue;
	
	public Task() {
		rewardValue = 0;
		taskName = "null task";
		dueDate = "never";
		positionInQueue = 0;
	}
	
	public int getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(int rewardValue) {
		this.rewardValue = rewardValue;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getPositionInQueue() {
		return positionInQueue;
	}

	public void setPositionInQueue(int positionInQueue) {
		this.positionInQueue = positionInQueue;
	}

	public Task (int rewardValueI, String taskNameI, String dueDateI, int positionInQueueI) {
		rewardValue = rewardValueI;
		taskName = taskNameI;
		dueDate = dueDateI;
		positionInQueue = positionInQueueI;
	}
	
	
}
