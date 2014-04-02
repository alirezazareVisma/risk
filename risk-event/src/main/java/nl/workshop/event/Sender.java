package nl.workshop.event;

public enum Sender {
	DATAAGGREGATER(1);

	private int type;

	private Sender(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
