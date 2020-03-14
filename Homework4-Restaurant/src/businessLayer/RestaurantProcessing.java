package businessLayer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface RestaurantProcessing {

	/**
	 * 
	 * @param name
	 * @param weight
	 * @param price
	 * @param ingredients
	 * @param id
	 * pre name != null
	 * pre weight != 0
	 * pre price != 0
	 * pre id != 0
	 * post product != null
	 */
	public void createNewMenuItem(String name, double weight, double price, ArrayList<MenuItem> ingredients, int id);
	
	/**
	 * 
	 * @param name
	 * pre name != null
	 */
	public void deleteMenuItem(String name);
	
	/**
	 * 
	 * @param name
	 * @param weight
	 * @param price
	 * @param ingredients
	 * @param id
	 * pre name != null
	 * pre weight != 0
	 * pre price != 0
	 * pre id != 0
	 * post product != null
	 */
	public void editMenuItem(String name, double weight, double price, ArrayList<MenuItem> ingredients, int id);
	
	/**
	 * 
	 * @param id
	 * @param date
	 * @param table
	 * @param menu
	 * @return
	 * pre id != 0
	 * pre date != null
	 * pre table != null
	 * pre menu != null
	 * post an order is created and returned
	 */
	public Order createNewOrder(int id, Date date, int table, ArrayList<MenuItem> menu);
	
	/**
	 * 
	 * @param o
	 * @return
	 * pre o != null
	 * post an order is created and returned
	 */
	public double computePrice(Order o);
	
	/**
	 * 
	 * @param order
	 * @param date
	 * @param tableNb
	 * @param price
	 * pre orer != null
	 * pre date != null
	 * pre tableNb != 0
	 * pre price != 0
	 */
	public void generateBill(int order, String date, int tableNb, double price);
	
	public void serializeRestaurant();
	
	public ArrayList<MenuItem> getItemList();
	
}
