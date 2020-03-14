package businessLayer;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
	private List<MenuItem> items = new ArrayList<MenuItem>();
	private double price;
	
	public CompositeProduct(String name, double weight, double price, List<MenuItem> items, int id, boolean type) {
		super(name, weight, id, type);
		this.items = items;
		this.price = price;
		// TODO Auto-generated constructor stub
	}	
	
	
	public void addItem(MenuItem item) {
		this.items.add(item);
	}
	
	public double computePrice() {
		int finalPrice = 0;
		for(int i=0; i<items.size(); i++) {
			finalPrice += items.get(i).computePrice();
		}
		return finalPrice;
	}
	
	public void deleteItem(String name) {
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getName().equals(name))
			{
				items.remove(i);
			}
		}
	}

	@Override
	public void setWeight(double weight) {
		// TODO Auto-generated method stub
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		double finalWeight = 0;
		for(int i=0; i<items.size(); i++) {
			finalWeight += items.get(i).getWeight();
		}
		return finalWeight;
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
}
