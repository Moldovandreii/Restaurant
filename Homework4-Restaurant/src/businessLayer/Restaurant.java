package businessLayer;
import java.util.*;
import dataLayer.*;
import presentationLayer.*;

public class Restaurant implements RestaurantProcessing, java.io.Serializable {
	private List<MenuItem> menu = new ArrayList<MenuItem>();
	private Map<Order, ArrayList<MenuItem>> orderInfo = new HashMap();
	//private int orderID;
	
	@Override
	public void createNewMenuItem(String name, double weight, double price, ArrayList<MenuItem> ingredients, int id) {
		assert name != null;
		assert weight != 0;
		assert price != 0;
		assert id != 0;
		MenuItem product;
		int size = menu.size();
		if(ingredients.size() == 0)
		{
			product = new BaseProduct(name, weight, price, id, false);
		}
		else
		{
			product = new CompositeProduct(name, weight, price, ingredients, id, true);
		}
		menu.add(product);
		assert size == menu.size() - 1;
	}

	@Override
	public void deleteMenuItem(String name) {
		assert name != null;
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).name.equals(name))
			{
				menu.remove(i);
			}
		}
		
	}

	@Override
	public void editMenuItem(String name, double weight, double price, ArrayList<MenuItem> ingredients, int id) {
		assert name != null;
		assert weight != 0;
		assert price != 0;
		assert id != 0;
		boolean found = false;
		if(ingredients.size() == 0)
		{
			for(int i=0; i<menu.size(); i++) {
				if(menu.get(i).name.equals(name))
				{
					menu.remove(i);
					found = true;
				}
			}
		}
		else
		{
			for(int i=0; i<menu.size(); i++) {
				if(menu.get(i).name.equals(name))
				{
					menu.remove(i);
					found = true;
				}
			}
		}
		if(found == true)
		{
			createNewMenuItem(name, weight, price, ingredients, id);  
		}
		else
		{
			System.out.println("No item with given name");
		}
		
		
	}

	@Override
	public Order createNewOrder(int id, Date date, int table, ArrayList<MenuItem> meniu) {
		assert id != 0;
		assert table != 0;
		Order order = new Order(id, date, table);
		orderInfo.put(order, meniu);
		
		return order;
	}

	@Override
	public double computePrice(Order o) {
		assert o != null;
		ArrayList<MenuItem> ingred = new ArrayList<MenuItem>();
		ingred = orderInfo.get(o);
		double price = 0;
		for(int i=0; i<ingred.size(); i++) {		
			price += ingred.get(i).computePrice();
		}
		return price;
	}
	
	@Override
	public ArrayList<MenuItem> getItemList(){
		return (ArrayList<MenuItem>) this.menu;
	}

	@Override
	public void generateBill(int order, String date, int tableNb, double price) {
		// TODO Auto-generated method stub
		FileWriter.createBill(order, date, tableNb, price);
	}
	

	@Override
	public void serializeRestaurant() {
		// TODO Auto-generated method stub
		//Restaurant r = new Restaurant();
		RestaurantSerializator.serializeObject(this);
	}
	
	/*public Restaurant getRest() {
		return this;
	}*/

	
}
