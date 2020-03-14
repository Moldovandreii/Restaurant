package presentationLayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class Controller {
	private AdministratorGUI adminView;
	private WaiterGUI waiterView;
	private ChefGUI chefView;
	private Restaurant r;
	
	public Controller(AdministratorGUI adminView, WaiterGUI waiterView, ChefGUI chefView, Restaurant r) {
		this.r = r;
		this.adminView = adminView;
		this.waiterView = waiterView;
		this.chefView = chefView; 
		adminView.addActionListener(new AddItem(), new EditItem(), new DeleteItem(), new Next(), new Prev(), new Select(), new Remove(), new CreateItem(), new RemoveItem());
		waiterView.addActionListener(new CreateOrder(), new ComputeBill(), new SelectItem());
		//chefView.addActionListener(new Load());
	}
	
	/*class Load implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			RestaurantSerializator.serializeObject(r);
		}
	}*/
	
	class CreateOrder implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String toAdd = waiterView.createOrder();
			chefView.update();
			waiterView.setItemList();
			//chefView.setInfo(toAdd);
		}
	}
	
	class ComputeBill implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class SelectItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			waiterView.selectItem();
		}
	}
	
	class Select implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			adminView.selectItem();
		}
		
	}
	
	class Remove implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = adminView.removeItem();
		}
	}
	
	
	class CreateItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = adminView.createItem();
			waiterView.getComboBox().addItem(name);
		}
		
	}
	
	class Next implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			adminView.getCl().show(adminView.getCardPanel(), "2");
		}
		
	}
	
	class Prev implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			adminView.getCl().show(adminView.getCardPanel(), "1");
		}
		
	}
	
	class AddItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = adminView.addNewItem();
			waiterView.getComboBox().addItem(name);
		}
		
	}
	
	class EditItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String[] name = adminView.editById();
			waiterView.getComboBox().removeItem(name[0]);
			waiterView.getComboBox().addItem(name[1]);
		}
		
	}
	
	class DeleteItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = adminView.deleteById();
			waiterView.getComboBox().removeItem(name);
		}
		
	}
	
	class RemoveItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String name = adminView.removeById();
			waiterView.getComboBox().removeItem(name);
		}
	}
	
	public static void main(String[] args) {
		Subject s = new Subject();
		Restaurant r = RestaurantSerializator.deserializeObject();
		AdministratorGUI adminView = new AdministratorGUI(r);
		WaiterGUI waiterView = new WaiterGUI(r, s);
		ChefGUI chefView = new ChefGUI(s);
		Controller c = new Controller(adminView, waiterView, chefView, r);
	}
	
}
