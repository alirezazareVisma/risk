package nl.workshop.event;

public enum Registrar {

	IMPORTER(1);

	private int type;

	private Registrar(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
