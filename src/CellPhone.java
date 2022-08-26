import java.util.Scanner;

public class CellPhone {
	private long serialNum = 0;
	private String brand;
	private int year;
	private double price;
	Scanner kb = new Scanner(System.in);
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.price = price;
		this.year = year;
	}
	public CellPhone(CellPhone cell, long serialNum) {
		this.serialNum = serialNum;
		this.brand = cell.brand;
		this.price = cell.price;
		this.year = cell.year;
	}
	public CellPhone clone() {
		System.out.println("Please enter a unique serial number for this cellphone: ");
		long sN = kb.nextLong();
		return new CellPhone(this, sN);
	}
	public String toString() {
		return this.serialNum+": "+this.brand+" "+this.price+"$ "+this.year;
	}
	public boolean equals(Object other) {
		if(other == null||this == null||this.getClass() != other.getClass()) 
			return false;
		else {
			CellPhone cell = (CellPhone) other;
			return ((this.brand.equals(cell.brand))&&(this.year == cell.year)&&(this.price == cell.price));
		}
		
	}
	public long getSerialNum() {
		return serialNum;
	}
}
