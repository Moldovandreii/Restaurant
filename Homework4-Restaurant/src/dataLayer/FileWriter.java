package dataLayer;
import java.io.*;

public class FileWriter {
	
	int counter = 1;
	
	public static void createBill(int order, String date, int tableNb, double price) {
		File file = new File("Order" + order + ".txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			pw.println("Order " + order + " has been created at date " + date + " for the table with the number " + tableNb + " for the price " + price );
			pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
