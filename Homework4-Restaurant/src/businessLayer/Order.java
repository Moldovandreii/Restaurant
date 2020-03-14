package businessLayer;
import java.util.Date;

public class Order implements java.io.Serializable {
	private int orderID;
	private Date date;
	private int table;
	
	public Order(int orderID, Date date, int table) {
		this.orderID = orderID;
		this.date = date;
		this.table = table;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderID;
		result = prime * result + table;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderID != other.orderID)
			return false;
		if (table != other.table)
			return false;
		return true;
	}
	
	public int getId() {
		return this.orderID;
	}
	
	public void setId(int id) {
		this.orderID = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTable() {
		return this.table;
	}
	
	public void setTable(int table) {
		this.table = table;
	}
	
}


















