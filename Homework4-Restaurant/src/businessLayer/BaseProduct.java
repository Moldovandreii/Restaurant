package businessLayer;
public class BaseProduct extends MenuItem {
	private double price;
	
	public BaseProduct(String name, double weight, double price, int id, boolean type) {
		super(name, weight, id, type);
		this.price = price;
		
	}

	@Override
	public void setWeight(double weight) {
		// TODO Auto-generated method stub
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public double computePrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	
	
	
}
