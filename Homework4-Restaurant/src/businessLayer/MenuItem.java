package businessLayer;
public abstract class MenuItem implements java.io.Serializable {
	protected int id;
	protected String name;
	protected double weight;
	protected boolean type;
	
	public MenuItem(String name, double weight, int id, boolean type) {
		this.name = name;
		this.weight = weight;
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return this.id;
	}
	
	public boolean getType() {
		return this.type;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.getWeight();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract double computePrice();
	
}

