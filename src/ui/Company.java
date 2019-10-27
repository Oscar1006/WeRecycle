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
		
		System.out.println("		Menu\n"
				+ " 1.Add residue\n"
				+ " 2.Generate report about the registred waste\n"
				+ " 3.Add product and the residues that may generate\n"
				+ " 4.Search information of a residue with its name\n"
				+ " 5.Search information of a residue with its id\n"
				+ " 6.Show list of the resistred products\n"
				+ " 7.Calculate harmful effect of a residue\n"
				+ " 8.Determine if a biodegradable or recyclable residue is usable\n"
				+ " 9.Ordenate the residues of a product by their nocive effect, showing the most nocive first");
		
		while(loop) {
			
		}

	}

}
