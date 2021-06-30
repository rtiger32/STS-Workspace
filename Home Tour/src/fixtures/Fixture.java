package fixtures;

public abstract class Fixture {

	private String name;
	private String shortDescription;
	private String longDescription;

	protected Fixture(String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	protected Fixture() {
		this.name = null;
		this.shortDescription = null;
		this.longDescription = null;
	}
	
	public void print() {
		System.out.println(name + "\n");
		System.out.println(longDescription + "\n");
	}
	
	protected String getShort( ) {
		return shortDescription;
	}
}
