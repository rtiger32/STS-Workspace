
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	protected abstract void print();
}
