import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		Scanner readFile = null;
		try {
			readFile = new Scanner(new FileInputStream("Cell_Info.txt"));
		}catch(FileNotFoundException notFound){
			System.out.println("File was not found.");
		}
		while(readFile.hasNextLine()) {
			long sn = 0;
			String brand = "";
			int year = 0;
			double price = 0;
			for(int i = 0;i<4;i++) {
				sn = readFile.nextLong();
				brand = readFile.next();
				price = readFile.nextDouble();
				year = readFile.nextInt();		
			}
			if(!(list1.contains(sn))) {
				CellPhone cell = new CellPhone(sn,brand,year,price);
				list1.addToStart(cell);
			}
			}
		list1.showContents();
		int iter = 0;
		long sn = 0;
		while(sn != -1) {
			System.out.println("Enter -1 to stop otherwise enter a serial number to search the list for it: ");
			System.out.println(list1.contains(sn));
			iter++;
		}
		System.out.println("Number of iterations: "+iter);
	}

}
