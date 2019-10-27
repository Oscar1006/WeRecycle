package ui;

import model.WeRecycle;
import java.util.Scanner;

public class Company {
	
	private WeRecycle weRecycle;
	
	private Scanner inputString;
	private Scanner inputInt;
	private Scanner inputDouble;
	
	public Company() {
		weRecycle = new WeRecycle();
		
		inputString = new Scanner(System.in);
		inputInt = new Scanner(System.in);
		inputDouble = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Company Recycler = new Company();
		int pick = 0;
		boolean loop = true;

	}

}
