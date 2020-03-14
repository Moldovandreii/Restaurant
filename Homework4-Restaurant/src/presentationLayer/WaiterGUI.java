package presentationLayer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import businessLayer.*;
import businessLayer.MenuItem;

public class WaiterGUI extends JFrame {
	private RestaurantProcessing rp;
	private JFrame frame = new JFrame();
	private JComboBox menuList = new JComboBox();
	private JScrollPane orderJsp;
	private JTable orderTable;
	private DefaultTableModel defaultTable;
	private JLabel priceTxt = new JLabel("");
	private JButton createOrder = new JButton("Create Order");
	private JLabel items = new JLabel("Items: ");
	private JLabel itemsTxt = new JLabel("");
	private JLabel table = new JLabel("Table");
	private JTextField tableTxt = new JTextField("");
	private JButton computeBill = new JButton("Compute bill");
	private JButton selectItem = new JButton("Select");
	private Subject subject;
	
	public WaiterGUI(RestaurantProcessing rp, Subject subject) {
		this.subject = subject;
		this.rp = rp;
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel defaultPanel = new JPanel();
		defaultPanel.setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		ArrayList<String[]> toAdd = baseTable();
		ArrayList<String[]> toAdd2 = compositeTable();
		for(int i=0; i<toAdd.size(); i++) {
			menuList.addItem(toAdd.get(i)[1]);
		}
		for(int i=0; i<toAdd2.size(); i++) {
			menuList.addItem(toAdd2.get(i)[1]);
		}
		
		
		menuList.setPreferredSize(new Dimension(150,30));
		items.setFont(new Font("Serif", Font.PLAIN, 20));
		table.setFont(new Font("Serif", Font.PLAIN, 20));
		itemsTxt.setPreferredSize(new Dimension(400,30));
		priceTxt.setPreferredSize(new Dimension(80,30));
		tableTxt.setPreferredSize(new Dimension(80,30));
		createOrder.setPreferredSize(new Dimension(120,30));
		computeBill.setPreferredSize(new Dimension(120,30));
		String[] tableHeader = {"Order", "Date", "Table"};
		defaultTable = new DefaultTableModel(tableHeader, 0);
		orderTable = new JTable(defaultTable);
		orderJsp = new JScrollPane(orderTable);
		
		
		panel1.add(menuList);
		panel1.add(items);
		panel1.add(itemsTxt);
		panel1.add(selectItem);
		panel1.add(table);
		panel1.add(tableTxt);
		panel1.add(createOrder);
		panel2.add(computeBill);
		panel2.add(priceTxt);
		panel3.add(orderJsp);
		
		defaultPanel.add(panel1);
		defaultPanel.add(panel2);
		defaultPanel.add(panel3);
		
		frame.setContentPane(defaultPanel);
		frame.setVisible(true);
		
	}
	
	/*public void computeBill() {
		
	}*/
	
	public ArrayList<String[]> baseTable() {
		ArrayList<MenuItem> lst = this.rp.getItemList();
		ArrayList<String[]> toAdd = new ArrayList<String[]>();
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getType() == false)
			{
				String[] item = {Integer.toString(lst.get(i).getId()), lst.get(i).getName(), Double.toString(lst.get(i).getWeight()), Double.toString(lst.get(i).computePrice())};
				toAdd.add(item);
			}	
		}
		return toAdd;
	}
	
	public ArrayList<String[]> compositeTable() {
		ArrayList<MenuItem> lst = this.rp.getItemList();
		ArrayList<String[]> toAdd = new ArrayList<String[]>();
		for(int i=0; i<lst.size(); i++) {
			if(lst.get(i).getType() == true)
			{
				String[] item = {Integer.toString(lst.get(i).getId()), lst.get(i).getName(), Double.toString(lst.get(i).getWeight()), Double.toString(lst.get(i).computePrice())};
				toAdd.add(item);
			}	
		}
		return toAdd;
	}
	
	public String createOrder() {
		int id = orderTable.getRowCount() + 1;
		Date date = new Date();
		String tableNb = tableTxt.getText();
		String[] toAdd = {Integer.toString(id), date.toString(), tableNb};
		defaultTable.addRow(toAdd);
		String[] items = itemsTxt.getText().split(", ");
		ArrayList<MenuItem> itemsInMenu = new ArrayList<MenuItem>();
		String itemsToPass = new String();
		for(int i=0; i<items.length; i++) {
			for(int j=0; j<rp.getItemList().size(); j++) {
				if(items[i].equals(rp.getItemList().get(j).getName()))
				{
					itemsToPass = itemsToPass.concat(rp.getItemList().get(j).getName() + " ");
					itemsInMenu.add(rp.getItemList().get(j));
				}
			}
		}
		Order o = rp.createNewOrder(id, date, Integer.parseInt(tableNb), itemsInMenu);
		double price = rp.computePrice(o);
		rp.generateBill(id, date.toString(), Integer.parseInt(tableNb), price);
		subject.setState("Order " + id + " has been processed at " + date + " at table: " + tableNb + ", items ordered: " + itemsToPass);
		return("Order " + id + " has been processed at " + date + " at table: " + tableNb + ", items ordered: " + itemsToPass);
	}
	
	public void selectItem() {
		String item = (String)menuList.getSelectedItem();
		String newText = new String();
		if(itemsTxt.getText().length() == 0)
		{
			newText = itemsTxt.getText().concat(item);
		}
		else
		{
			newText = itemsTxt.getText().concat(", " + item);
		}
		itemsTxt.setText(newText);
	}
	
	
	public JComboBox getComboBox() {
		return this.menuList;
	}
	
	public void addActionListener(ActionListener createOrder, ActionListener computePrice, ActionListener selectItem) {
		this.createOrder.addActionListener(createOrder);
		this.computeBill.addActionListener(computePrice);  
		this.selectItem.addActionListener(selectItem);
	}
	
	public void setItemList() {
		this.itemsTxt.setText("");
	}
	
	public static void main(String[] args) {
		Restaurant r = new Restaurant();
		Subject s = new Subject();
		WaiterGUI view = new WaiterGUI(r, s);
	}
	
	
}
