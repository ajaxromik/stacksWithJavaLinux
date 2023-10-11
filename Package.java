public class Package extends Sample {

	private int amount;
	private boolean healthy;
	private String sender;
	private String receiver;

	public Package(String name, double weight, int amount, boolean healthy, String sender, String receiver) {
		super(name, weight);
		this.amount = amount;
		this.healthy = healthy;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getAmount() {
		return amount;
	}

	public boolean getHealthy() {
		return healthy;
	}

	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public double getWeight() {
		return amount*getUnitWeight();
	}

	public String toString() {
		return String.format("%d %ss, each weighing %.2f lbs"
				+" from %s to %s", 
				amount, super.getName(), super.getWeight(), sender, receiver);
	}

}