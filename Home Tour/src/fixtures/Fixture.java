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
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getShortDescription() {
		return shortDescription;
	}

	protected void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	protected String getLongDescription() {
		return longDescription;
	}

	protected void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	protected abstract void print();
}
