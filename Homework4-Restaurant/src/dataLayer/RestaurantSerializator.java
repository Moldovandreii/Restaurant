package dataLayer;
import java.io.*;

import businessLayer.Restaurant;

public abstract class RestaurantSerializator {
	
	public static void serializeObject(Restaurant r) {
		FileOutputStream file;
		try {
			file = new FileOutputStream("file");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(r);
			out.close();
			file.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch(IOException e) 
		{
			System.out.println("IOException is caught1");
		}
	}
	
	public static Restaurant deserializeObject() {
		Restaurant r = new Restaurant();
		try {
			FileInputStream file = new FileInputStream("file");
			ObjectInputStream in = new ObjectInputStream(file);
			r = (Restaurant)in.readObject();
			in.close();
			file.close();
		}catch(IOException e) 
		{
			System.out.println("IOException is caught2");
		}
		 catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		return r;
	}
}
