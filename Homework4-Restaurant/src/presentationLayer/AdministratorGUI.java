package presentationLayer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.table.DefaultTableModel;

import businessLayer.*;
import businessLayer.MenuItem;
import dataLayer.*;

public class AdministratorGUI extends JFrame {
	private RestaurantProcessing rp;
	private JButton next = new JButton("next--->");
	private JButton prev = new JButton("prev<---");
	private JFrame frame = new JFrame();
	private JLabel itemId = new JLabel("ID: ");
	private JTextField itemIdTxt = new JTextField("");
	private JLabel itemName = new JLabel("Name: ");
	private JTextField itemNameTxt = new JTextField("");
	private JLabel itemWeight = new JLabel("Weight: ");
	private JTextField itemWeightTxt = new JTextField("");
	private JLabel itemPrice = new JLabel("Price: ");
	private JTextField itemPriceTxt = new JTextField("");
	private JButton addItem = new JButton("Add");
	private JButton editItem = new JButton("Edit");
	private JButton deleteItem = new JButton("Delete");
	private JButton removeItem = new JButton("Delete");
	private JTextField removeId = new JTextField("");
	private JScrollPane itemJsp;
	private DefaultTableModel defaultTable;
	private JTable itemTable;
	private CardLayout cl = new CardLayout();
	private JPanel cardPanel = new JPanel();
	private JPanel defaultPanel = new JPanel();
	private JPanel secondPanel = new JPanel();
	private JLabel menuName = new JLabel("Name");
	private JTextField menuNameTxt = new JTextField("");
	private JComboBox itemList;
	private JButton select = new JButton("Select");
	private JButton remove = new JButton("Remove");
	private JButton createItem = new JButton("Create Item");
	private JLabel ingredients = new JLabel("Ingredients: ");
	private JLabel ingredientsTxt = new JLabel("");
	private DefaultTableModel defaultTable2;
	private JTable itemTable2;
	private JScrollPane itemJsp2;
	
	public AdministratorGUI(RestaurantProcessing rp) {
		this.rp = rp;
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardPanel.setLayout(cl);
		defaultPanel.setLayout(new FlowLayout());
		secondPanel.setLayout(new FlowLayout());
		cardPanel.add(defaultPanel, "1");
		cardPanel.add(secondPanel, "2");
		cl.show(cardPanel, "1");  
		JPanel switchPage = new JPanel();
		switchPage.setLayout(new FlowLayout());
		JPanel itemData = new JPanel();
		itemData.setLayout(new FlowLayout());
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JPanel table = new JPanel();
		table.setLayout(new FlowLayout());
		JLabel space1 = new JLabel("         ");
		space1.setPreferredSize(new Dimension(800,60));
		space1.setFont(new Font("Serif", Font.PLAIN, 260));
		itemName.setFont(new Font("Serif", Font.PLAIN, 20));
		itemId.setFont(new Font("Serif", Font.PLAIN, 20));
		itemWeight.setFont(new Font("Serif", Font.PLAIN, 20));
		itemPrice.setFont(new Font("Serif", Font.PLAIN, 20));
		itemNameTxt.setPreferredSize(new Dimension(75,30));
		itemIdTxt.setPreferredSize(new Dimension(45,30));
		itemWeightTxt.setPreferredSize(new Dimension(45,30));
		itemPriceTxt.setPreferredSize(new Dimension(45,30));
		addItem.setPreferredSize(new Dimension(80,30));
		deleteItem.setPreferredSize(new Dimension(80,30));
		editItem.setPreferredSize(new Dimension(80,30));
		next.setPreferredSize(new Dimension(80,30));
		
		switchPage.add(space1);
		switchPage.add(next);
		itemData.add(itemId);
		itemData.add(itemIdTxt);
		itemData.add(itemName);
		itemData.add(itemNameTxt);
		itemData.add(itemWeight);
		itemData.add(itemWeightTxt);
		itemData.add(itemPrice);
		itemData.add(itemPriceTxt);
		buttons.add(addItem);
		buttons.add(editItem);
		buttons.add(deleteItem);
		String[] tableHeader = {"ID", "Name", "Weight", "Price"};
		defaultTable = new DefaultTableModel(tableHeader, 0);
		itemTable = new JTable(defaultTable);
		itemJsp = new JScrollPane(itemTable);
		
		ArrayList<String[]> toAdd = baseTable();
		for(int i=0; i<toAdd.size(); i++) {
			defaultTable.addRow(toAdd.get(i));	
		}
		
		table.add(itemJsp);
		defaultPanel.add(itemData);
		defaultPanel.add(buttons);
		defaultPanel.add(table);
		defaultPanel.add(switchPage);
		
		
		JPanel switchPage2 = new JPanel();
		switchPage2.setLayout(new BoxLayout(switchPage2, BoxLayout.Y_AXIS));
		JLabel space2 = new JLabel("      ");
		space2.setPreferredSize(new Dimension(150,30));
		prev.setPreferredSize(new Dimension(80,30));
		menuName.setFont(new Font("Serif", Font.PLAIN, 20));
		ingredients.setFont(new Font("Serif", Font.PLAIN, 20));
		menuNameTxt.setPreferredSize(new Dimension(80,30));
		removeId.setPreferredSize(new Dimension(80,30));
		ingredientsTxt.setPreferredSize(new Dimension(400,30));
		select.setPreferredSize(new Dimension(80,30));
		remove.setPreferredSize(new Dimension(80,30));
		removeItem.setPreferredSize(new Dimension(80,30));
		itemList = new JComboBox();
		itemList.setPreferredSize(new Dimension(150,30));
		
		for(int i=0; i<toAdd.size(); i++) {
			itemList.addItem(toAdd.get(i)[1]);
		}
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout());
		
		String[] tableHeader2 = {"ID", "Name", "Weight", "Price"};
		defaultTable2 = new DefaultTableModel(tableHeader2, 0);
		itemTable2 = new JTable(defaultTable2);
		itemJsp2 = new JScrollPane(itemTable2);
		
		ArrayList<String[]> toAdd2 = compositeTable();
		for(int i=0; i<toAdd2.size(); i++) {
			defaultTable2.addRow(toAdd2.get(i));	
		}
		
		panel1.add(itemList);
		panel1.add(select);
		panel1.add(remove);
		panel2.add(menuName);
		panel2.add(menuNameTxt);
		panel2.add(ingredients);
		panel2.add(ingredientsTxt);
		panel2.add(createItem);
		panel2.add(removeItem);
		panel2.add(removeId);
		panel3.add(itemJsp2);
		panel4.add(prev);
		switchPage2.add(panel1);
		switchPage2.add(panel2);
		switchPage2.add(panel3);
		switchPage2.add(panel4);
		secondPanel.add(switchPage2);
		
		
		frame.setContentPane(cardPanel);
		frame.setVisible(true);
		
	}
	
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
	
	public String addNewItem() {
		int id = itemTable.getRowCount() + 1;
		String[] toAdd = {Integer.toString(id), itemNameTxt.getText(), itemWeightTxt.getText(), itemPriceTxt.getText()};
		defaultTable.addRow(toAdd);
		itemList.addItem(itemNameTxt.getText());
		ArrayList<MenuItem> lst = new ArrayList<MenuItem>();
		rp.createNewMenuItem(itemNameTxt.getText(), Double.parseDouble(itemWeightTxt.getText()), Double.parseDouble(itemPriceTxt.getText()), lst, id);
		rp.serializeRestaurant();			
		return itemNameTxt.getText();
	}
	
	public String removeById() {
		String id = removeId.getText();
		String name = new String();
		for(int i=0; i<itemTable2.getRowCount(); i++) { 
			if(itemTable2.getValueAt(i, 0).equals(id)) {  
				name = (String) itemTable2.getValueAt(i, 1);
				itemList.removeItem(itemTable2.getValueAt(i, 1));
				defaultTable2.removeRow(i);
				rp.deleteMenuItem(name);
			}
		}	
		for(int i=0; i<itemTable2.getRowCount(); i++) {
			String str = Integer.toString(i+1);
			defaultTable2.setValueAt(str, i, 0);
			//itemTable.setValueAt(i+1, i, 0);
		}
		rp.serializeRestaurant();
		return name;
	}
	
	public String deleteById() {
		//int id = Integer.parseInt(itemIdTxt.getText());
		String id = itemIdTxt.getText();
		String name = new String();
		for(int i=0; i<itemTable.getRowCount(); i++) { 
			if(itemTable.getValueAt(i, 0).equals(id)) {  
				name = (String) itemTable.getValueAt(i, 1);
				itemList.removeItem(itemTable.getValueAt(i, 1));
				defaultTable.removeRow(i);
				rp.deleteMenuItem(name);
			}
		}	
		for(int i=0; i<itemTable.getRowCount(); i++) {
			String str = Integer.toString(i+1);
			defaultTable.setValueAt(str, i, 0);
			//itemTable.setValueAt(i+1, i, 0);
		}
		rp.serializeRestaurant();
		return name;
	}	
	
	public String[] editById() {
		int id = Integer.parseInt(itemIdTxt.getText());
		String oldName = new String();
		String newName = itemNameTxt.getText();
		String toRemove = (String) itemTable.getValueAt(id-1, 1);
		itemList.removeItem(toRemove);
		itemList.addItem(itemNameTxt.getText());
		String strId = itemIdTxt.getText();
		for(int i=0; i<itemTable.getRowCount(); i++) {
			if(itemTable.getValueAt(i, 0).equals(strId)) {
				oldName = (String) itemTable.getValueAt(id-1, 1);
				defaultTable.setValueAt(itemNameTxt.getText(), i, 1);
				defaultTable.setValueAt(itemWeightTxt.getText(), i, 2);
				defaultTable.setValueAt(itemPriceTxt.getText(), i, 3);
				ArrayList<MenuItem> lst = new ArrayList<MenuItem>();
				rp.editMenuItem(newName, Double.parseDouble(itemWeightTxt.getText()), Double.parseDouble(itemPriceTxt.getText()), lst, id);
			}
		}
		String name[] = {oldName, newName};
		rp.serializeRestaurant();
		
		return name;
	}
	
	public void selectItem() {
		String item = itemList.getSelectedItem().toString();
		String newText = new String();
		if(ingredientsTxt.getText().length() == 0)
		{
			newText = ingredientsTxt.getText().concat(item);
		}
		else
		{
			newText = ingredientsTxt.getText().concat(", " + item);
		}
		ingredientsTxt.setText(newText);
		rp.serializeRestaurant();
	}
	
	public String removeItem() {
		String item = itemList.getSelectedItem().toString();
		String ingr = ingredientsTxt.getText();
		String newText = new String();
		if(ingr.contains(item))
		{
			newText = ingr.replace(item, "");
		}
		if(newText.length() != 0 && newText.length() != 1 )
		{
			if(newText.charAt(0) == ',' || newText.charAt(1) == ',')
			{
				newText = newText.replaceFirst(",", "");
			}
		}
		for(int i=2; i<newText.length(); i++) {
			if((newText.charAt(i-2) == ',') && (newText.charAt(i-1) == ' ') && (newText.charAt(i) == ',') )
			{
				newText = newText.replaceFirst(",", "");
			}
		}
		ingredientsTxt.setText(newText);
		rp.serializeRestaurant();
		return item;
	}
	
	public String createItem() {
		int id = itemTable2.getRowCount() + 1;
		String name = menuNameTxt.getText();
		String[] items = ingredientsTxt.getText().split(", ");
		ArrayList<MenuItem> itemsInMenu = new ArrayList<MenuItem>();
		double price = 0;
		double weight = 0;
		for(int i=0; i<items.length; i++) {
			for(int j=0; j<rp.getItemList().size(); j++) {
				if(items[i].equals(rp.getItemList().get(j).getName()))
				{
					itemsInMenu.add(rp.getItemList().get(j));
					price += rp.getItemList().get(j).computePrice();
					weight += rp.getItemList().get(j).getWeight();
				}
			}
		}
		String[] toAdd = {Integer.toString(id), name, Double.toString(weight), Double.toString(price)};
		rp.createNewMenuItem(name, weight, price, itemsInMenu, id);
		defaultTable2.addRow(toAdd);
		itemList.addItem(name);
		ArrayList<MenuItem> lst = rp.getItemList();
		rp.serializeRestaurant();
		return name;
		
	}
	
	public void addActionListener(ActionListener addItem, ActionListener editItem, ActionListener deleteItem, ActionListener next, ActionListener prev, ActionListener select, ActionListener remove, ActionListener createItem, ActionListener removeItem) {
		this.addItem.addActionListener(addItem);
		this.editItem.addActionListener(editItem);
		this.deleteItem.addActionListener(deleteItem);
		this.next.addActionListener(next);
		this.prev.addActionListener(prev);
		this.select.addActionListener(select);
		this.remove.addActionListener(remove);
		this.createItem.addActionListener(createItem);
		this.removeItem.addActionListener(removeItem);
	}
	
	public CardLayout getCl() {
		return this.cl;
	}
	
	public JPanel getCardPanel() {
		return this.cardPanel;
	}
	
	
	public static void main(String[] args) {
		Restaurant r = new Restaurant();
		AdministratorGUI view = new AdministratorGUI(r);
	}
}
