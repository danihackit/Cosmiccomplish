public class Task {
	private String rewardValue;
	private String taskName;
	private String dueDate;
	private String positionInQueue;
	
	public Task() {
		rewardValue = "null";
		taskName = "null task";
		dueDate = "never";
		positionInQueue = "null";
	}
	
	public String getRewardValue() {
		return rewardValue;
	}

	public void setRewardValue(String rewardValue) {
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

	public String getPositionInQueue() {
		return positionInQueue;
	}

	public void setPositionInQueue(String positionInQueue) {
		this.positionInQueue = positionInQueue;
	}

	public Task (String rewardValueI, String taskNameI, String dueDateI, String positionInQueueI) {
		rewardValue = rewardValueI;
		taskName = taskNameI;
		dueDate = dueDateI;
		positionInQueue = positionInQueueI;
	}
	
	
}
